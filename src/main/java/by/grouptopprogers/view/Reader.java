package view;


import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;


import by.grouptopprogers.parsers.MyDOMparser;
import org.xml.sax.SAXException;

public class Reader extends JFrame {

    MyDOMparser myDOMparser = new MyDOMparser();
    MySAXparser mySAXparser = new MySAXparser();

    JButton btnParceDom, btnParceSAX, btnClear, btnFilter;
    JTextArea area;
    JComboBox boxCompany;
    JScrollPane sp;

    JLabel labeId;
    JTextField textFieldId;
    JTextField textFileName;

    JTable table;

    private Category curentCategory = new Category();

    ArrayList<Category> lData;

    public Reader(String str) {
        super(str);
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lData = new ArrayList();


        btnParceDom = new JButton("Parse DOM");
        btnParceSAX = new JButton("Parse SAX");
        btnClear = new JButton("Сброс");
        btnFilter = new JButton("Найти");

        area = new JTextArea(9, 9);
        area.setEditable(false);

        setLayout(null);

        sp = new JScrollPane(area);

        btnParceDom.setBounds(10, 450, 100, 30);
        btnParceSAX.setBounds(10,480,100,30);
        btnClear.setBounds(120, 450, 100, 30);
        btnFilter.setBounds(250, 130, 200, 30);

        area.setBounds(10, 10, 220, 300);
        sp.setBounds(10, 10, 220, 300);

        boxCompany = new JComboBox();
        boxCompany.setBounds(250, 30, 200, 30);

        labeId = new JLabel("Поиск по ID");
        labeId.setBounds(250, 60, 200, 30);

        textFieldId = new JTextField();
        textFieldId.setBounds(250,85, 200, 30);

        textFileName = new JTextField();
        textFileName.setBounds(10, 320, 220, 30);
        textFileName.setText("office.xml");

        table = new JTable();
        table.setBounds(10, 600, 400, 100);

        add(btnParceDom);
        add(btnParceSAX);
        add(btnClear);
        add(btnFilter);
        add(sp);
        add(boxCompany);
        add(labeId);
        add(textFieldId);
        add(textFileName);
        add(table);
        setVisibleElements(false);
        btnParceDom.addActionListener(new ButtonActionDOMListener());
        btnParceSAX.addActionListener(new ButtonActionSAXListner());
        btnClear.addActionListener(new DelActionListener());
        btnFilter.addActionListener(new ButtonFilterListener());
    }

    private void setVisibleElements(boolean flag){
        btnFilter.setVisible(flag);
        labeId.setVisible(flag);
        textFieldId.setVisible(flag);
    }

    public void setlData(ArrayList<Category> lData) {
        this.lData = lData;
    }

    public void setNewTextList(ArrayList arrayList, JTextArea jTextArea) {
        jTextArea.setText(null);
        for (Object str : arrayList) {
            jTextArea.append(str.toString());
            jTextArea.append("\n");
        }
        setContent(arrayList);
    }

    public void setContent(ArrayList<Category> list) {
        boxCompany.removeAllItems();
        boxCompany.addItem("...");
        for (Category obj : list) {
            boxCompany.addItem(obj.getNameCategory());
        }
        setVisibleElements(true);
    }

    public class ButtonActionDOMListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnParceDom) {
                try {
                    myDOMparser.setFileName(textFileName.getText());
                    setlData(myDOMparser.parseFile());
                    setNewTextList(lData, area);
                } catch (IOException | SAXException | ParserConfigurationException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Нет такого файла");
                }

            }
        }
    }

    public class ButtonActionSAXListner implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == btnParceSAX) {
                try {
                    mySAXparser.setFileName(textFileName.getText());
                    setlData(mySAXparser.parseFile());
                    setNewTextList(lData, area);
                } catch (SAXException | ParserConfigurationException | IOException e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Нет такого файла");
                }

            }
        }
    }

    public class DelActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnClear) {
                area.setText(null);
                boxCompany.removeAllItems();
                setVisibleElements(false);
            }
        }
    }

    public class ButtonFilterListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                if (e.getSource() == btnFilter) {
                    if (area.getText() != "") {
                        for (Product objProd : curentCategory.getListProducts()) {
                            if (objProd.getId() == Integer.parseInt(textFieldId.getText())) {
                                area.setText(objProd.toString());
                            }
                        }
                    } else {
                        area.setText(curentCategory.toString());
                    }
                }
            } catch(NumberFormatException exp){
                System.out.println(exp.getMessage());
            }
        }
    }

}


