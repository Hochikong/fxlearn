import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

public class SwingWorkerExample {

    private static JFrame frame;
    private static JButton btnStart;
    private static JButton btnStop;
    private static JProgressBar progress;
    private static Integer currValue;
    private static boolean swingWorkerHelper;
    private static SwingWorker<Integer, Void> swingWorker;

    public static void main(String[] args) {
        // Scheduling Swing app for the event dispatch thread(EDT) Asynchronously
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runSwingAsynchronousApp();
            }
        });
    }

    private static void runSwingAsynchronousApp() {
        currValue = new Integer(0);

        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");

        progress = new JProgressBar();
        progress.setMinimum(0);
        progress.setMaximum(100);
        progress.setStringPainted(true);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                if (btnStart.getText().equals("Pause")) {
                    // interrupting swingWorker method doInBackground() implicitly safely.
                    swingWorkerHelper = false;
                    btnStart.setText("Resume");
                } else {
                    if (btnStart.getText().equals("Start") || btnStart.getText().equals("Resume"))
                        btnStart.setText("Pause");

                    showProgress();
                }
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // checking swingWorker Object is initialized or not
                if (swingWorker != null) {
                    // checking is swingWorker doing process in background or not
                    if (swingWorker.getState() == SwingWorker.StateValue.STARTED) {
                        btnStart.setText("Start");
                        // interrupting swingWorker method doInBackground() explicitly
                        swingWorker.cancel(true);
                        currValue = new Integer(0);
                    }
                }
            }
        });

        frame = new JFrame();
        frame.setTitle("Asynchronously trigger JProgressBar");
        frame.getContentPane().setLayout(new GridLayout(3, 2));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(400, 250, 400, 300);

        frame.getContentPane().add(btnStart);
        frame.getContentPane().add(btnStop);
        frame.getContentPane().add(progress);

        frame.setVisible(true);
    }

    private static void showProgress() {
        swingWorker = new SwingWorker<Integer, Void>() {
            @Override
            protected Integer doInBackground() throws Exception {

                if (!swingWorkerHelper)
                    swingWorkerHelper = true;

                while (currValue < progress.getMaximum() && swingWorkerHelper) {
                    try {
                        progress.setValue(++currValue);

                        if (isCancelled())
                            return currValue;

                        Thread.sleep(70);
                    } catch (InterruptedException iex) {
                        swingWorkerHelper = false;
                        System.out.println("Stop Button interrupted SwingWorker process...");
                    }
                }
                return currValue;
            }

            @Override
            public void done() {
                System.out.printf("Progress ends with value %s " +
                        (isCancelled() ? "with" : "without") + " interruption.\n", currValue);
                if (currValue >= progress.getMaximum()) {
                    btnStart.setText("Start");
                    currValue = new Integer(0);
                }
            }
        };
        swingWorker.execute();
    }

}
