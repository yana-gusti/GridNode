/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Pages;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 *
 * @author yana
 */
public class OSXConsole extends JPanel {
    public static final long serialVersionUID = 21362469L;

    private JTextPane textPane;
    private PipedOutputStream pipeOut;
    private PipedInputStream pipeIn;


    public OSXConsole() {
        super(new BorderLayout());
        textPane = new JTextPane();
        this.add(textPane, BorderLayout.CENTER);

        redirectSystemStreams();

        textPane.setBackground(Color.GRAY);
        textPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    }


    private void updateTextPane(final String text) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Document doc = textPane.getDocument();
                try {
                    doc.insertString(doc.getLength(), text, null);
                } catch (BadLocationException e) {
                    throw new RuntimeException(e);
                }
                textPane.setCaretPosition(doc.getLength() - 1);
            }
        });
    }


    private void redirectSystemStreams() {
      OutputStream out = new OutputStream() {
        @Override
        public void write(final int b) throws IOException {
          updateTextPane(String.valueOf((char) b));
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
          updateTextPane(new String(b, off, len));
        }

        @Override
        public void write(byte[] b) throws IOException {
          write(b, 0, b.length);
        }
      };

      System.setOut(new PrintStream(out, true));
      System.setErr(new PrintStream(out, true));
    }


}
//         System.out.print("Enter your name: ");
//
//      //  open up standard input
//      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//      String userName = null;
//
//      //  read the username from the command-line; need to use try/catch with the
//      //  readLine() method
//      try {
//         userName = br.readLine();
//      } catch (IOException ioe) {
//         System.out.println("IO error trying to read your name!");
//         System.exit(1);
//      }
//
//      System.out.println("Thanks for the name, " + userName);
 

//    finally {
//        try {
//            reader_.close();
//        } catch ( IOException ioe ) {
//            ioe.printStackTrace();
//        }
//    }