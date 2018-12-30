package spark.taxi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Evgeny Borisov
 */
public class MyFrame extends JFrame {
    public MyFrame(int[] counter) throws HeadlessException {
        counter[0]++;
        JButton jButton = new JButton();
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(counter);
            }
        });
    }
}
