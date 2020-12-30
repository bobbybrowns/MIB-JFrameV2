/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MIB.Inloggning.Sidor;

import MIB.Validering;
import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;
import java.util.HashMap;


/**
 *
 * @author Hampus
 */
public class AndraAlien extends javax.swing.JPanel {
    private InfDB idb;
    private HashMap<String, Boolean> sqlUpdate;
    private boolean namnHarVarde;
    private boolean telefonHarVarde;
    private boolean rasHarVarde;
    private boolean platsHarVarde;
    private boolean arvHarVarde;
    private boolean losenordHarVarde;

    
    
    
    public AndraAlien(InfDB databasen) {
        initComponents();
        idb = databasen;
        namnHarVarde = false;
        telefonHarVarde = false;
        rasHarVarde =  false;
        platsHarVarde = false;
        arvHarVarde = false;
        losenordHarVarde =  false;
        jArv.setVisible(false);
        jArvInput.setVisible(false);
        sqlUpdate = new HashMap<>();
        
        
        
        settAlienID();
        setRas();
        setPlats();  
    }
    
    public void uppdateraAlien(){
        String sqlQ;
        sqlUpdate = setValue();
        for(String i : sqlUpdate.keySet()){
            sqlQ = " " + i + " = '" + sqlUpdate.get(i) + "' ,";
        }
        System.out.println();
        // update alien set 'boleantyp' = 'textvärdefältet' where alien_id  = cbbox1;
    }
    
    
    public void setBooleans(){
        if(!tfNamn.getText().isEmpty()){
            namnHarVarde = true;
            System.out.println(namnHarVarde);
        } 
        
        if(!tfTelefon.getText().isEmpty()){
            telefonHarVarde = true;
        } else {
            telefonHarVarde = false;
        }
        
        char[] password = pfLosenord.getPassword();
        String losen = String.valueOf(password);
        if(!losen.isEmpty() && Validering.passwordSix(pfLosenord)){
            losenordHarVarde = true;
        } else {
            losenordHarVarde = false;
        }
    }
    public HashMap setValue() {   
        setBooleans();
        
        sqlUpdate.put("NAMN",namnHarVarde);
        sqlUpdate.put("TELEFON,",telefonHarVarde);
        sqlUpdate.put("LOSENORD",losenordHarVarde);
        sqlUpdate.put("PLATS",platsHarVarde);
        sqlUpdate.put("RAS",rasHarVarde);
        sqlUpdate.put(jComboBox1.getSelectedItem().toString(),arvHarVarde);
        
        for(String key : sqlUpdate.keySet()){
            System.out.println(sqlUpdate.get(key));
            if(sqlUpdate.get(key) == false){
                sqlUpdate.entrySet().remove(key);
            } else {
                
            }
        }
    
        
        return sqlUpdate;
    }

    public void settAlienID(){
        String fraga = "select Alien_id from alien";
        ArrayList<String>fyllCB = new ArrayList<>();
        
        try {
            fyllCB = idb.fetchColumn(fraga);
            
        } catch(InfException e){
            
        }
        
        for(String alienID : fyllCB) {
            jComboBox1.addItem(alienID);
        }
    }
    
    public void setRas(){ 
        cbRas.addItem("-");
        cbRas.addItem("Ingen ras");
        cbRas.addItem("BOGLODITE"); // LÄGG TILL FÖR BOOGIES
        cbRas.addItem("SQUID"); // LÄGG TILL FÖR ARMAR
        cbRas.addItem("WORM");
    }
        public void setPlats(){
             cbPlats.addItem("-");
        String fraga = "select omrades_id from omrade";
        ArrayList<String>fyllCB = new ArrayList<>();
        
        try {
            fyllCB = idb.fetchColumn(fraga);
            
        } catch(InfException e){
            
        }
        
        for(String alienID : fyllCB) {
            cbPlats.addItem(alienID);
        }
    }
     
    

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfNamn = new javax.swing.JTextField();
        pfLosenord = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfTelefon = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbRas = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        btnSpara = new javax.swing.JButton();
        cbPlats = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jArvInput = new javax.swing.JTextField();
        jArv = new javax.swing.JLabel();
        lblAlienNamnFranCB = new javax.swing.JLabel();

        jLabel1.setText("Ändra informationen om alien nedan");

        jLabel2.setText("Namn");

        tfNamn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamnActionPerformed(evt);
            }
        });

        pfLosenord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pfLosenordActionPerformed(evt);
            }
        });

        jLabel3.setText("Lösenord");

        jLabel4.setText("Telefon");

        tfTelefon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefonActionPerformed(evt);
            }
        });

        jLabel5.setText("Plats");

        cbRas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRasActionPerformed(evt);
            }
        });

        jLabel7.setText("Ras");

        btnSpara.setText("Spara");
        btnSpara.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSparaActionPerformed(evt);
            }
        });

        cbPlats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPlatsActionPerformed(evt);
            }
        });

        jLabel6.setText("Välj en alien från Ett Alien_Id som du vill ändra");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jArvInput.setText("jTextField1");
        jArvInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jArvInputActionPerformed(evt);
            }
        });

        jArv.setText("Om sant visa");

        lblAlienNamnFranCB.setText("Aliennamn");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(109, 109, 109))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(28, 28, 28)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlienNamnFranCB)
                            .addComponent(btnSpara, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(cbRas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbPlats, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tfTelefon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(pfLosenord, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfNamn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                        .addGap(24, 24, 24)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jArvInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jArv, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlienNamnFranCB))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfNamn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(pfLosenord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(tfTelefon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbPlats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jArv))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jArvInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSpara)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
    sattNamnlblAlienNamn();
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void cbPlatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPlatsActionPerformed
        try{
        if(!cbPlats.getSelectedItem().equals("-")){
            platsHarVarde = true;
        } else {
            platsHarVarde = false;
        }
        } catch (NullPointerException e) {
            
        }
    }//GEN-LAST:event_cbPlatsActionPerformed

    private void sattNamnlblAlienNamn(){
        
        String hamtaVardeCB = "select namn from alien where alien_id=" + jComboBox1.getSelectedItem().toString();
        try{lblAlienNamnFranCB.setText(idb.fetchSingle(hamtaVardeCB));}
            catch(InfException e){
                    
                    }
        
    }
    private void cbRasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRasActionPerformed
        try{
        if(!cbPlats.getSelectedItem().equals("-")){
           rasHarVarde = true;
           jArv.setVisible(true);
            jArvInput.setVisible(true);  
            if(jArvInput.getText().equals("BOGLODITE")){
                jArv.setText("Ange hur många boogies");
            } else if(jArvInput.getText().equals("SQUID")) {
                jArv.setText("Ange hur många armar");
            } else {
                jArv.setVisible(false);
                jArvInput.setVisible(false);
            }
        } else {
            rasHarVarde = false;
        } 
        } catch (NullPointerException e) {
            
        }

    }//GEN-LAST:event_cbRasActionPerformed

    private void btnSparaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSparaActionPerformed
        
        System.out.println(sqlUpdate);
            
        
    }//GEN-LAST:event_btnSparaActionPerformed

    private void tfNamnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamnActionPerformed
       
    }//GEN-LAST:event_tfNamnActionPerformed

    private void tfTelefonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefonActionPerformed

    }//GEN-LAST:event_tfTelefonActionPerformed

    private void pfLosenordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pfLosenordActionPerformed

    }//GEN-LAST:event_pfLosenordActionPerformed

    private void jArvInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jArvInputActionPerformed
        if(!jArvInput.getText().isEmpty()){
            arvHarVarde = true;
        } else {
            arvHarVarde = false;
        }
    }//GEN-LAST:event_jArvInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSpara;
    private javax.swing.JComboBox<String> cbPlats;
    private javax.swing.JComboBox<String> cbRas;
    private javax.swing.JLabel jArv;
    private javax.swing.JTextField jArvInput;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblAlienNamnFranCB;
    private javax.swing.JPasswordField pfLosenord;
    private javax.swing.JTextField tfNamn;
    private javax.swing.JTextField tfTelefon;
    // End of variables declaration//GEN-END:variables
}
