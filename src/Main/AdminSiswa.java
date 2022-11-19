/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package Main;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author SYAFIQ
 */
public class AdminSiswa extends javax.swing.JInternalFrame {
    
    Connection conn;
    Statement stmt;
    ResultSet rs;
    String sql;
    
    public String strIdKelas;
    public String strKelas;

    /**
     * Creates new form AdminSiswa
     */
    public AdminSiswa() {
        initComponents();
        
        DBConnection DB = new DBConnection();
        DB.config();
        conn = DB.conn;
        stmt = DB.stm;
        
        getData();
        addKelas();
    }
    
    public void getData() {
        try {
            sql = "SELECT s.nisn, s.nama, k.tingkat, k.kelas FROM tb_siswa s JOIN tb_kelas k WHERE s.id_kelas = k.id";
            rs = stmt.executeQuery(sql);
            tblSiswa.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void clearInput() {
        txtNISN.setText("");
        txtNama.setText("");
        txtTmpLahir.setText("");
        dateLahir.setCalendar(null);
        btgKelamin.clearSelection();
        areaAlamat.setText("");
        txtOrtu.setText("");
        txtSPP.setText("");
        txtNoHP.setText("");
        cmbKelas.setSelectedIndex(0);
        txtOldNisn.setText("");
    }
    
    public void addKelas() {
        try {
            sql = "SELECT * FROM tb_kelas ORDER BY tingkat ASC, kelas ASC";
            rs = stmt.executeQuery(sql);
            while(rs.next()) {
                cmbKelas.addItem(rs.getString("id") + "-" + rs.getString("tingkat") + rs.getString("kelas"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
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

        btgKelamin = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNISN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtTmpLahir = new javax.swing.JTextField();
        radPerempuan = new javax.swing.JRadioButton();
        radLaki = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaAlamat = new javax.swing.JTextArea();
        dateLahir = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtOrtu = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtSPP = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblSiswa = new javax.swing.JTable();
        btnClear = new javax.swing.JButton();
        cmbKelas = new javax.swing.JComboBox<>();
        btnCreate = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        txtNoHP = new javax.swing.JTextField();
        txtOldNisn = new javax.swing.JTextField();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Data Siswa");

        jLabel2.setText("Form");

        jLabel3.setText("NISN");

        jLabel4.setText("Nama");

        jLabel5.setText("Tempat Lahir");

        jLabel6.setText("Tgl Lahir");

        jLabel7.setText("Jenis Kelamin");

        jLabel8.setText("Alamat");

        btgKelamin.add(radPerempuan);
        radPerempuan.setText("Perempuan");

        btgKelamin.add(radLaki);
        radLaki.setText("Laki-laki");

        areaAlamat.setColumns(20);
        areaAlamat.setRows(5);
        jScrollPane1.setViewportView(areaAlamat);

        dateLahir.setDateFormatString("yyyy-MM-dd");

        jLabel9.setText("Orang Tua");

        jLabel10.setText("SPP");

        jLabel11.setText("Kelas");

        jLabel12.setText("Data");

        tblSiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblSiswa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSiswaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblSiswa);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        btnCreate.setText("Create");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        jLabel13.setText("No HP");

        txtOldNisn.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7)
                            .addComponent(jLabel11)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13)
                            .addComponent(btnClear))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radLaki)
                                        .addGap(18, 18, 18)
                                        .addComponent(radPerempuan))
                                    .addComponent(jScrollPane1)
                                    .addComponent(dateLahir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTmpLahir)
                                    .addComponent(txtNISN)
                                    .addComponent(txtNama)
                                    .addComponent(txtOrtu)
                                    .addComponent(txtSPP)
                                    .addComponent(txtNoHP)
                                    .addComponent(cmbKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCreate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnUpdate)
                                .addGap(12, 12, 12)
                                .addComponent(btnDelete)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(txtOldNisn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel1)))
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel12)
                    .addComponent(txtOldNisn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNISN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(txtTmpLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(dateLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radLaki)
                            .addComponent(radPerempuan)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtOrtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtSPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(cmbKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnClear)
                            .addComponent(btnCreate)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        clearInput();
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:
        
        // Declare variabels and get user input
        String strNisn = txtNISN.getText();
        String strNama = txtNama.getText();
        String strTmpLahir = txtTmpLahir.getText();
        String strTglLahir = "";
        String strKelamin = "";
        String strAlamat = areaAlamat.getText();
        String strOrtu = txtOrtu.getText();
        String strSPP = txtSPP.getText();
        String strNoHP = txtNoHP.getText();
        String strKelas = cmbKelas.getSelectedItem().toString();
        
        // Select Kelamin
        if(radLaki.isSelected()) {
            strKelamin = "Laki-laki";
        } else {
            strKelamin = "Perempuan";
        }
        
        // Get Date
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        strTglLahir = date.format(dateLahir.getDate());
        
        // Split strKelas to get kelas id
        String[] idKelas = strKelas.split("-");
        
        // Create Process
        try {
            sql = "INSERT INTO tb_siswa VALUES('"+strNisn+"', '"+strNama+"', '"+strTmpLahir+"', '"+strTglLahir+"', '"+strKelamin+"', '"+strAlamat+"', '"+strOrtu+"', '"+strNoHP+"', '"+strSPP+"', '"+idKelas[0]+"')";
            stmt.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Ditambah!");
            clearInput();
            getData();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

//        JOptionPane.showMessageDialog(null, strTglLahir);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void tblSiswaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSiswaMouseClicked
        // TODO add your handling code here:
        
        int row = tblSiswa.getSelectedRow();
        String id = tblSiswa.getModel().getValueAt(row, 0).toString();
        
        try {
            sql = "SELECT * FROM tb_siswa WHERE nisn = '"+id+"'";
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                txtNISN.setText(rs.getString("nisn"));
                txtNama.setText(rs.getString("nama"));
                txtTmpLahir.setText(rs.getString("tmp_lahir"));
                
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("tgl_lahir"));
                dateLahir.setDate(date);
                
                if(rs.getString("kelamin").equals("Laki-laki")) {
                    radLaki.setSelected(true);
                } else {
                    radPerempuan.setSelected(true);
                }
                
                areaAlamat.setText(rs.getString("alamat"));
                txtOrtu.setText(rs.getString("nama_ortu"));
                txtSPP.setText(rs.getString("biaya_spp"));
                txtNoHP.setText(rs.getString("no_hp"));
                
                int length = cmbKelas.getItemCount();
                for(int i =0; i<length; i++) {
                    String kelas = cmbKelas.getItemAt(i);
                    String[] idKelas = kelas.split("-");
                    if(idKelas[0].equals(rs.getString("id_kelas"))) {
                        cmbKelas.setSelectedIndex(i);
                    }
                }
                
                txtOldNisn.setText(rs.getString("nisn"));
            }
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblSiswaMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        
        // Declare variabels and get user input
        String strOldNisn = txtOldNisn.getText();
        String strNisn = txtNISN.getText();
        String strNama = txtNama.getText();
        String strTmpLahir = txtTmpLahir.getText();
        String strTglLahir = "";
        String strKelamin = "";
        String strAlamat = areaAlamat.getText();
        String strOrtu = txtOrtu.getText();
        String strSPP = txtSPP.getText();
        String strNoHP = txtNoHP.getText();
        String strKelas = cmbKelas.getSelectedItem().toString();
        
        // Select Kelamin
        if(radLaki.isSelected()) {
            strKelamin = "Laki-laki";
        } else {
            strKelamin = "Perempuan";
        }
        
        // Get Date
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        strTglLahir = date.format(dateLahir.getDate());
        
        // Split strKelas to get kelas id
        String[] idKelas = strKelas.split("-");
        
        // Update Process
        try {
            sql = "UPDATE tb_siswa SET nisn = '"+strNisn+"', nama = '"+strNama+"', tmp_lahir = '"+strTmpLahir+"', tgl_lahir = '"+strTglLahir+"', kelamin = '"+strKelamin+"', alamat = '"+strAlamat+"', nama_ortu = '"+strOrtu+"', no_hp = '"+strNoHP+"', id_kelas = '"+idKelas[0]+"' WHERE nisn = '"+strOldNisn+"'";
            stmt.execute(sql);
            JOptionPane.showMessageDialog(null, "Data Berhasil Di-Update!");
            clearInput();
            getData();
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        String strOldNisn = txtOldNisn.getText();
        
        // Delete Process
        try {
            sql = "DELETE FROM tb_siswa WHERE nisn = '"+strOldNisn+"'";
            stmt.execute(sql);
            clearInput();
            getData();
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus!");
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaAlamat;
    private javax.swing.ButtonGroup btgKelamin;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbKelas;
    private com.toedter.calendar.JDateChooser dateLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JRadioButton radLaki;
    private javax.swing.JRadioButton radPerempuan;
    private javax.swing.JTable tblSiswa;
    private javax.swing.JTextField txtNISN;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoHP;
    private javax.swing.JTextField txtOldNisn;
    private javax.swing.JTextField txtOrtu;
    private javax.swing.JTextField txtSPP;
    private javax.swing.JTextField txtTmpLahir;
    // End of variables declaration//GEN-END:variables
}
