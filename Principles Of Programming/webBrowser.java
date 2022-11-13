import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
@SuppressWarnings("serial")
public class webBrowser extends JFrame {
	private JTextField addressField;
    private JEditorPane window;
    public webBrowser() {
        super("Simple Web Browser Demo");
        setBackground(Color.ORANGE);
        addressField = new JTextField("Enter a URL!");
        addressField.setBounds(0, 0, 434, 20);
        addressField.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent event) {
                        loadSite(event.getActionCommand());
                    }
                }
                );
        getContentPane().setLayout(null);
        getContentPane().add(addressField);
        window = new JEditorPane();
        window.setEditable(false);
        window.addHyperlinkListener(
                new HyperlinkListener() {
                    public void hyperlinkUpdate(HyperlinkEvent event) {
                        if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        loadSite(event.getURL().toString());
                        }
                    }
                }
                );
        JScrollPane scrollPane = new JScrollPane(window);
        scrollPane.setBounds(0, 20, 434, 241);
        getContentPane().add(scrollPane);
    }
    private void loadSite(String text) {
        try {
            window.setPage(text);
            addressField.setText(text);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid URL!");
        }
    }
}