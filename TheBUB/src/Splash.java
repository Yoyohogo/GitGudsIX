//imports
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;
import static jdk.nashorn.internal.objects.NativeString.indexOf;

public class Splash extends javax.swing.JFrame {

    static String title; //global String to store the title
    File url = new File ("Y:\\Documents\\lastURL.txt");
    public Splash() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        urlInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        lastViewed = new javax.swing.JButton();
        test = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(400, 300));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/A little bit bigger.png"))); // NOI18N

        urlInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlInputActionPerformed(evt);
            }
        });

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        lastViewed.setText("Display Last Viewed Page");
        lastViewed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastViewedActionPerformed(evt);
            }
        });

        test.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(115, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(searchButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(urlInput, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lastViewed, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(test, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(47, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(urlInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(searchButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastViewed)
                .addGap(18, 18, 18)
                .addComponent(test)
                .addContainerGap(129, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lastViewedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastViewedActionPerformed
        //try-catch for error handling if file cannot be read
        try {
            FileReader out = new FileReader(url); //opens output stream
            BufferedReader readFile = new BufferedReader(out);
            String line;
            
            while ((line = readFile.readLine()) != null ) { //retrieve URL from file and use to search
            search(line);
            }
            
            readFile.close(); //close the output stream
            out.close();
            
            
        
            
        } catch (IOException e) {
            test.setText("Error: No previous URL on record.");
        }
        

    }//GEN-LAST:event_lastViewedActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //try-catch for error handling if invalid URL is entered
        try {
            test.setText(""); //clear error field
            search(urlInput.getText()); //call search method with inputted url
            
            FileWriter in = new FileWriter(url); //opens input stream
            BufferedWriter writeFile = new BufferedWriter(in);
            writeFile.write(""+urlInput.getText()); //store the URL into the file for later use
            writeFile.close(); //close input stream
            in.close();
            
        } catch (IOException e) {
            test.setText("Please provide a valid URL.");
        }


    }//GEN-LAST:event_searchButtonActionPerformed

    private void urlInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlInputActionPerformed
        //try-catch for invalid URL input
        try {
            search(urlInput.getText());
            
            FileWriter in = new FileWriter(url); //opens input stream
            BufferedWriter writeFile = new BufferedWriter(in);
            writeFile.write(""+urlInput.getText()); //store the URL into the file for later use
            writeFile.close(); //close input stream
            in.close();
            
        } catch (IOException e) {
            test.setText("Please provide a valid URL.");
        }
    }//GEN-LAST:event_urlInputActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Splash().setVisible(true);
            }
        });
    }
    
    /**
     * this method connects to a website, stores all of its html code and then calls methods to organize the html code
     * pre: url
     * post: calls methods to search and sort html code
     */
    public void search(String url) throws IOException {
        //declare variable
        String htmlText; 
        
        //connect to website
        URLConnection connection;
        connection = new URL(url).openConnection();
        Scanner kb = new Scanner(connection.getInputStream());
        kb.useDelimiter("\\Z");
        
        //organize information 
        htmlText = kb.next(); //store html code in String
        titleFind(htmlText); //find the title of the website
        ArrayList<text> paragraphs = bodyFind(htmlText); //find the paragraphs of the website
        ArrayList<text> headers = headerFind(htmlText); //find the headers of the website
        sort(paragraphs, headers); //order headers and paragraphs into the order in which they appear
    }

    /**
     * this method finds and records the title of the website
     * pre: htmlText 
     * post: sets the title 
     */
    public void titleFind(String htmlText) {
        int indexOfStart = indexOf(htmlText, "<title>") + 7; //find the start of the title
        int indexOfEnd = indexOf(htmlText, "</title>"); //find the end of the title
        title = htmlText.substring(indexOfStart, indexOfEnd); //create a substring containing the title 
    }
    
    /**
     * This method returns the title 
     * post: returns title
     */
    public static String titleGet() {
        return title; 
    }

    /**
     * This method converts all paragraphs into paragraph objects and then stores them in an ArrayList
     * pre: htmlText
     * post: paragraphs 
     */
    public static ArrayList<text> bodyFind(String htmlText) {
        //declare variables
        String htmlTextRemain = htmlText;
        int indexOfStart = 0;
        int indexOfEnd = 0;
        ArrayList<text> paragraphs = new ArrayList<text>();
        
        //find and store all paragraphs in a String ArrayList
        while (htmlTextRemain.contains("<p>")) { //keep searching if paragraphs remain
            indexOfStart = indexOf(htmlTextRemain, "<p>"); //find the start of the paragraph
            indexOfEnd = indexOf(htmlTextRemain, "</p>") + 4; //find the end of the paragraph          
            if (indexOfStart < indexOfEnd) { //If statement to catch errors   
                paragraphs.add(new text(htmlTextRemain.substring(indexOfStart, indexOfEnd), htmlText)); //create paragraph object and add paragraph to the ArrayList
            }
            htmlTextRemain = htmlTextRemain.substring(indexOfEnd + 4, htmlTextRemain.length()); //Remove the html code already searched
        }
        
        return paragraphs;
    }

    /**
     * This method converts all headers into header objects and then stores them in an ArrayList
     * pre: htmlText
     * post: headers 
     */
    public static ArrayList<text> headerFind(String htmlText) {
        //declare variables
        String htmlTextRemain = htmlText;
        int indexOfStart = 0;
        int indexOfEnd = 0;
        ArrayList<text> headers = new ArrayList<text>();
        
        //find and store all headers in a String ArrayList
        while (htmlTextRemain.contains("<h")) { //keep searching if headers remain
            String i = htmlTextRemain.substring(indexOf(htmlTextRemain, "<h") + 2, indexOf(htmlTextRemain, "<h") + 3); //obtain the character after h
            if ("1".equals(i) || "2".equals(i) || "3".equals(i) || "4".equals(i) || "5".equals(i) || "6".equals(i)) { //check if the character after h is a size (numbers 1-6)
                indexOfStart = indexOf(htmlTextRemain, "<h" + i); //find the start of the header
                indexOfEnd = indexOf(htmlTextRemain, "</h" + i + ">") + 4; //find the end of the header                          
                if (indexOfStart < indexOfEnd) { //If statement to catch errors   
                    headers.add(new text(htmlTextRemain.substring(indexOfStart, indexOfEnd), htmlText)); //create header object and add header to the ArrayList
                }
            } else {
                indexOfEnd = indexOf(htmlTextRemain, "<h"); //if the character after h is not a size set the end to the h selected to signal that it has already been searched
            }
            htmlTextRemain = htmlTextRemain.substring(indexOfEnd + 2, htmlTextRemain.length()); //Remove the html code already searched
        }
        
        return headers;
    }

    /**
     * this method orders the paragraphs and headers into the order in which they appeared
     * pre: paragraphs, headers 
     * post: output 
     */
    public static void sort(ArrayList<text> paragraphs, ArrayList<text> headers) {
        //declare variables
        String output = "";
        int indexP = 0;
        int indexH = 0;
        
        for (int i = 0; i < paragraphs.size() + headers.size(); i++) { //run the following code as many times as there is paragraphs and headers 
            if (paragraphs.get(indexP).returnPosition() < headers.get(indexH).returnPosition()) { //check if the selected paragraph appears before theselected header
                output = output + paragraphs.get(indexP).returnText() + "\n"; //add the selected paragraph to output
                if (indexP < paragraphs.size() - 1) { //check if there is still more paragraphs not added to output
                    indexP++; //select the next paragraph
                } else {
                    paragraphs.get(indexP).setPosition(1000000000); //set the paragraph location to after everything
                }
            } else {
                output = output + headers.get(indexH).returnText() + "\n"; //add the selected header to output
                if (indexH < headers.size() - 1) { //check if there is still more headers not added to output
                    indexH++; //select the next header
                } else {
                    headers.get(indexH).setPosition(1000000000); //set the header location to after everything
                }
            }
        }
        
        //Create a new page object to display the output
        Page s = new Page();
        s.setVisible(true);
        s.displayBody(output);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton lastViewed;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel test;
    private javax.swing.JTextField urlInput;
    // End of variables declaration//GEN-END:variables
}
