package ktmeta;

import bibliothek.gui.dock.common.*;
import bibliothek.gui.dock.common.menu.SingleCDockableListMenuPiece;
import bibliothek.gui.dock.facile.menu.RootMenuPiece;
import com.formdev.flatlaf.intellijthemes.FlatSolarizedLightIJTheme;

import javax.swing.*;
import java.awt.*;

public class DockPane {
    public static void main(String[] args) {
        FlatSolarizedLightIJTheme.install();

        JFrame frame = new JFrame("Demo");
        CControl control = new CControl(frame);

        frame.add(control.getContentArea());

        CGrid grid = new CGrid(control);
        grid.add(0, 0, 1, 1, createDockable("Red", Color.RED));
        grid.add(1, 0, 1, 1, createDockable("Green", Color.GREEN));
        grid.add(2, 0, 1, 1, createDockable("Blue", Color.BLUE));
        grid.add(1, 1, 1, 1, createDockable("Yellow", Color.YELLOW));
        control.getContentArea().deploy(grid);

        SingleCDockable black = createDockable("Black", Color.BLACK);
        control.addDockable(black);
        black.setLocation(CLocation.base().minimalEast());
        black.setVisible(true);

        RootMenuPiece menu = new RootMenuPiece("Colors", false);
        menu.add(new SingleCDockableListMenuPiece(control));
        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu.getMenu());
        frame.setJMenuBar(menuBar);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(20, 20, 400, 400);
        frame.setVisible(true);
    }

    public static SingleCDockable createDockable(String title, Color color) {
        JPanel panel = new JPanel();
        panel.setOpaque(true);
        panel.setBackground(color);
        DefaultSingleCDockable dockable = new DefaultSingleCDockable(title, title, panel);
        dockable.setCloseable(true);
        return dockable;
    }
}
