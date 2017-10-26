
package assignment_2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * <h1>Assignment 2 - Due 22Feb2017</h1>
 * 
 * Jumping the gun a bit here, but this requires only a little bit of work from Chapter 3, so you
 * can either start now and read on your own, or wait until after we get to cover this in class.
 * This is a simple little app, but it requires doing some logic testing. Here's the requirement: I
 * want you to write a program that is a "Service Advisor" for a car. You type in the mileage of
 * your car, and it will tell you about any service that is required within the next two thousand
 * miles.
 * 
 * I want you to use the JOptionPane dialog boxes, rather than console I/O to get input and display
 * output. Your output might consist of several lines, depending on what's needed.
 * 
 * Here's the data: Oil Change - every 6000 miles Tire Rotation - every 8000 miles Tire Condition
 * Check - every 5000 miles Tire Replacement - every 41000 miles Air Filter Replacement - every
 * 14000 miles Spark Plug Replacement - every 32000 miles Timing Belt Replacement - every 65000
 * miles Cabin Air Filter Replacement - every 22000 miles
 * 
 * You should be able to enter the current mileage of your car, and have it list everything that is
 * due within the next 2000 miles. A suggestion for telling if you're within that mileage? Use the
 * "Modulo" operator, like car mileage modulo spark plug interval, if that remainder is 2000 or
 * less, then you need to print this out. If it isn't, then skip it.
 * 
 * Be sure you test this with high mileage values - me, I'm used to getting my money's worth out of
 * a car, so I've run Hyundais well past the 200,000 mile mark and had them going strong.
 * 
 * When you have this working, do like you did the last program, copy/past the java file, and attach
 * it here. This is due on Monday, February 20th. Questions? Let me know.
 * 
 * @author dputnam3 "David Putnam"
 * @version 1.1
 *
 */
public class ServiceAdvisor {

    private final JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ServiceAdvisor window = new ServiceAdvisor();
                    window.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public ServiceAdvisor() {
        frame = new JFrame();
        initialize();
    }

    /**
     * 
     * @param visible
     */
    public void setVisible(boolean visible) {
        frame.setVisible(visible);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame.setBounds(100, 100, 450, 300);
        frame.setMinimumSize(new Dimension(350, 150));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        // Build the North content within a JPanel and separate layout
        JPanel northPanel = new JPanel();
        frame.getContentPane().add(northPanel, BorderLayout.NORTH);
        FlowLayout northLayout = new FlowLayout();
        northPanel.setLayout(northLayout);
        JLabel mileageLabel = new JLabel("Mileage:");
        northPanel.add(mileageLabel);
        JTextField mileageText = new JTextField("Miles", 7);
        northPanel.add(mileageText);
        JLabel toleranceLabel = new JLabel("Within:");
        northPanel.add(toleranceLabel);
        JTextField toleranceField = new JTextField("2000", 5);
        northPanel.add(toleranceField);
        JButton btnAdvise = new JButton("Advise");
        northPanel.add(btnAdvise);

        // Center content
        JTextArea resultTextArea = new JTextArea();
        resultTextArea.setEditable(false);
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
        frame.getContentPane().add(resultScrollPane, BorderLayout.CENTER);

        // South content
        JButton btnQuit = new JButton("Quit");
        frame.getContentPane().add(btnQuit, BorderLayout.SOUTH);

        // implement actions for the buttons
        frame.getRootPane().setDefaultButton(btnAdvise);
        btnQuit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        btnAdvise.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                boolean error = false;
                MaintenanceIntervals intervals = new MaintenanceIntervals();
                StringBuffer text = new StringBuffer();
                String mileageString = mileageText.getText();
                Long mileage = 0l;
                try {
                    mileage = Long.parseLong(mileageString);
                    if (mileage < 0) {
                        throw new IllegalArgumentException("Mileage cannot be negative. \"" + mileageString + "\"");
                    }
                } catch (Exception e) {
                    text.append(e.toString() + "\n");
                    error = true;
                }
                String toleranceString = toleranceField.getText();
                Long tolerance = 0l;
                try {
                    tolerance = Long.parseLong(toleranceString);
                    if (tolerance < 0) {
                        throw new IllegalArgumentException("Tolerance cannot be negative.\"" + toleranceString + "\"");
                    }
                } catch (Exception e) {
                    text.append(e.toString() + "\n");
                    error = true;
                }
                // if the following takes too long it should be submitted to a
                // new thread
                if (!error) {
                    Map<String, Long> servicesDue = intervals.selectMaintenanceDue(mileage, tolerance);
                    if (servicesDue.size() > 0) {
                        // TODO: sort the keySet by the miles to service.
                        for (String key : servicesDue.keySet()) {
                            long when = servicesDue.get(key).longValue();
                            String description = (when == 0l) ? "now." : "in " + when + " miles.";
                            text.append("\t" + key + " due " + description + "\n");
                        }
                    } else {
                        text.append("\tNone.\n");
                    }
                }
                resultTextArea.setText(text.toString());
            }
        });
    }

}
