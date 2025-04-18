/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;
import java.sql.*;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
/**
 *
 * @author Bayu Aji Purnomo
 */
public class master_kasir extends javax.swing.JFrame {
private Connection conn = new koneksi().connect();
    private DefaultTableModel tabmode;
    /**
     * Creates new form master_kasir
     */
    public master_kasir() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        kosong();
        aktif();
        datatable_kasir();
        alamat_kasir.setLineWrap(true);
        alamat_kasir.setWrapStyleWord(true);
    }

    protected void aktif() {
        id_kasir.requestFocus();
    }

    protected void kosong() {
        id_kasir.setText("");
        nama_kasir.setText("");
        jk_kasir.clearSelection();
        telp_kasir.setText("");
        agama_kasir.setText("");
        alamat_kasir.setText("");
        password_kasir.setText("");
    }
    
    protected void datatable_kasir() {
        Object[] Baris = {"Id Kasir", "Nama", "Jenis Kelamin", "No Telp", "Agama", "Alamat", "Password"};
        tabmode = new DefaultTableModel(null, Baris);
        String cariitem = cari_text.getText();
        try {
            String sql = "SELECT * FROM tb_kasir WHERE id_kasir LIKE '%" + cariitem + "%' "
                    + "OR nama_kasir LIKE '%" + cariitem + "%' "
                    + "OR jk_kasir LIKE '%" + cariitem + "%' "
                    + "OR telp_kasir LIKE '%" + cariitem + "%' "
                    + "OR agama_kasir LIKE '%" + cariitem + "%' "
                    + "OR alamat_kasir LIKE '%" + cariitem + "%' "
                    + "OR password_kasir LIKE '%" + cariitem + "%' "
                    + "ORDER BY id_kasir ASC";
            Statement stat = conn.createStatement();
            ResultSet hasil = stat.executeQuery(sql);
            while (hasil.next()) {
                tabmode.addRow(new Object[]{
                    hasil.getString(1),
                    hasil.getString(2),
                    hasil.getString(3),
                    hasil.getString(4),
                    hasil.getString(5),
                    hasil.getString(6),
                    hasil.getString(7)
                });
            }
            table_kasir.setModel(tabmode);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Data gagal dipanggil" + e);
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

        jk_kasir = new javax.swing.ButtonGroup();
        buttonGroup1 = new javax.swing.ButtonGroup();
        rlaki = new javax.swing.JRadioButton();
        rperempuan = new javax.swing.JRadioButton();
        telp_kasir = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamat_kasir = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table_kasir = new javax.swing.JTable();
        cari_text = new javax.swing.JTextField();
        bcari = new javax.swing.JButton();
        bsimpan = new javax.swing.JButton();
        bubah = new javax.swing.JButton();
        bhapus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        nama_kasir = new javax.swing.JTextField();
        bbatal = new javax.swing.JButton();
        bkeluar = new javax.swing.JButton();
        id_kasir = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        agama_kasir = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        password_kasir = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jk_kasir.add(rlaki);
        rlaki.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rlaki.setText("Laki-Laki");
        rlaki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rlakiActionPerformed(evt);
            }
        });

        jk_kasir.add(rperempuan);
        rperempuan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rperempuan.setText("Perempuan");

        alamat_kasir.setColumns(20);
        alamat_kasir.setRows(5);
        jScrollPane1.setViewportView(alamat_kasir);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "DATA KASIR", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        table_kasir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7"
            }
        ));
        table_kasir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_kasirMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table_kasir);

        cari_text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cari_textActionPerformed(evt);
            }
        });
        cari_text.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cari_textKeyPressed(evt);
            }
        });

        bcari.setText("CARI");
        bcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bcariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(cari_text, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bcari)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cari_text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bcari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                .addContainerGap())
        );

        bsimpan.setText("SIMPAN");
        bsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bsimpanActionPerformed(evt);
            }
        });

        bubah.setText("UBAH");
        bubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bubahActionPerformed(evt);
            }
        });

        bhapus.setText("HAPUS");
        bhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bhapusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Kasir");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("ID Kasir :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Jenis Kelamin :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nama :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("No. Telepon :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Alamat :");

        nama_kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_kasirActionPerformed(evt);
            }
        });

        bbatal.setText("BATAL");
        bbatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bbatalActionPerformed(evt);
            }
        });

        bkeluar.setText("KELUAR");
        bkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bkeluarActionPerformed(evt);
            }
        });

        id_kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_kasirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Agama :");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Password :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(54, 54, 54)
                                                .addComponent(id_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(53, 53, 53))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(54, 54, 54)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(agama_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(rlaki)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(rperempuan))
                                                    .addComponent(telp_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(password_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(bsimpan)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(bubah)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(bhapus)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(bbatal)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bkeluar)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(nama_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(217, 217, 217))))))
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(id_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(nama_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rlaki)
                    .addComponent(rperempuan)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(telp_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(agama_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(password_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bsimpan)
                    .addComponent(bubah)
                    .addComponent(bhapus)
                    .addComponent(bbatal)
                    .addComponent(bkeluar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean idSudahTerdaftar(String id_kasir) {
        String sql = "SELECT id_kasir FROM tb_kasir WHERE id_kasir = ?";
        try (PreparedStatement stat = conn.prepareStatement(sql)) {
            stat.setString(1, id_kasir);
            ResultSet hasil = stat.executeQuery();
            return hasil.next(); // Mengembalikan true jika ID ditemukan di database
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal memeriksa ID Kasir: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return false; // Mengembalikan false jika terjadi kesalahan (anggap ID tidak terdaftar)
        }
    }
    private void table_kasirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_kasirMouseClicked
        int bar = table_kasir.getSelectedRow();
        String a = table_kasir.getValueAt(bar, 0).toString();
        String b = table_kasir.getValueAt(bar, 1).toString();
        String c = table_kasir.getValueAt(bar, 2).toString();
        String d = table_kasir.getValueAt(bar, 3).toString();
        String e = table_kasir.getValueAt(bar, 4).toString();
        String f = table_kasir.getValueAt(bar, 5).toString();
        String g = table_kasir.getValueAt(bar, 6).toString();

        id_kasir.setText(a);
        nama_kasir.setText(b);
        if ("Laki-Laki".equals(c)) {
            rlaki.setSelected(true);
        } else {
            rperempuan.setSelected(true);
        }
        telp_kasir.setText(d);
        agama_kasir.setText(e);
        alamat_kasir.setText(f);
        password_kasir.setText(g);
    }//GEN-LAST:event_table_kasirMouseClicked

    private void cari_textKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cari_textKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            datatable_kasir();
        }
    }//GEN-LAST:event_cari_textKeyPressed

    private void bcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bcariActionPerformed
        datatable_kasir();
    }//GEN-LAST:event_bcariActionPerformed

    private void bsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bsimpanActionPerformed
        String id_kasirText = id_kasir.getText().trim(); // Trim untuk menghapus spasi di awal dan akhir
        String namaText = nama_kasir.getText().trim();
        String hpText = telp_kasir.getText().trim();
        String agamaText = agama_kasir.getText().trim();
        String alamatText = alamat_kasir.getText().trim();
        String passText = password_kasir.getText().trim();
        if (id_kasirText.isEmpty() || namaText.isEmpty() || hpText.isEmpty() || agamaText.isEmpty() || alamatText.isEmpty() || passText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (id_kasirText.length() > 10) {
            JOptionPane.showMessageDialog(this, "ID Kasir harus terdiri dari 10 digit.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (idSudahTerdaftar(id_kasirText)) {
            JOptionPane.showMessageDialog(this, "ID Kasir sudah terdaftar.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!rlaki.isSelected() && !rperempuan.isSelected()) {
            JOptionPane.showMessageDialog(this, "Jenis kelamin harus dipilih.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String jenis = null;
        if (rlaki.isSelected()) {
            jenis = "Laki-Laki";
        } else if (rperempuan.isSelected()) {
            jenis = "Perempuan";
        }
        String sql = "insert into tb_kasir values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, id_kasirText);
            stat.setString(2, namaText);
            stat.setString(3, jenis);
            stat.setString(4, hpText);
            stat.setString(5, agamaText);
            stat.setString(6, alamatText);
            stat.setString(7, passText);

            stat.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            kosong();
            aktif();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan!" + e);
        }
        datatable_kasir();
    }//GEN-LAST:event_bsimpanActionPerformed

    private void bubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bubahActionPerformed
        String id_kasirText = id_kasir.getText().trim(); // Trim untuk menghapus spasi di awal dan akhir
        String namaText = nama_kasir.getText().trim();
        String hpText = telp_kasir.getText().trim();
        String agamaText = agama_kasir.getText().trim();
        String alamatText = alamat_kasir.getText().trim();
        String passText = password_kasir.getText().trim();
        if (id_kasirText.isEmpty() || namaText.isEmpty() || hpText.isEmpty() || agamaText.isEmpty() || alamatText.isEmpty() || passText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (id_kasirText.length() > 10) {
            JOptionPane.showMessageDialog(this, "ID Kasir harus terdiri dari 10 digit.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!rlaki.isSelected() && !rperempuan.isSelected()) {
            JOptionPane.showMessageDialog(this, "Jenis kelamin harus dipilih.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String jenis = null;
        if (rlaki.isSelected()) {
            jenis = "Laki-Laki";
        } else if (rperempuan.isSelected()) {
            jenis = "Perempuan";
        }
        String sql = "UPDATE tb_kasir set nama_kasir=?,jk_kasir=?,telp_kasir=?,agama_kasir=?,alamat_kasir=?,password_kasir=? where id_kasir=?" ;
        try {
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, namaText);
            stat.setString(2, jenis);
            stat.setString(3, hpText);
            stat.setString(4, agamaText);
            stat.setString(5, alamatText);
            stat.setString(6, passText);
            stat.setString(7, id_kasirText);

            int rowsUpdated = stat.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
                kosong();
                aktif();
            } else {
                JOptionPane.showMessageDialog(null, "Data gagal diubah. ID Kasir tidak ditemukan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan!" + e);
        }
        datatable_kasir();
    }//GEN-LAST:event_bubahActionPerformed

    private void bhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bhapusActionPerformed
        String idKasir = id_kasir.getText().trim();
        if (idKasir.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID Kasir belum diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (!idSudahTerdaftar(idKasir)) {
            JOptionPane.showMessageDialog(this, "ID Kasir tidak ditemukan.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int ok = JOptionPane.showConfirmDialog(null, "Apakah benar ingin dihapus?", "Peringatan!", JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            String sql = "delete from tb_kasir where id_kasir='" + id_kasir.getText() + "'";
            try {
                PreparedStatement stat = conn.prepareStatement(sql);
                stat.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                kosong();
                aktif();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Data gagal dihapus" + e);
            }
            datatable_kasir();
        }
    }//GEN-LAST:event_bhapusActionPerformed

    private void nama_kasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_kasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_kasirActionPerformed

    private void bbatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bbatalActionPerformed
        kosong();
        datatable_kasir();
    }//GEN-LAST:event_bbatalActionPerformed

    private void bkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bkeluarActionPerformed
        dispose();
    }//GEN-LAST:event_bkeluarActionPerformed

    private void id_kasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_kasirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_id_kasirActionPerformed

    private void cari_textActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cari_textActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cari_textActionPerformed

    private void rlakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rlakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rlakiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(master_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(master_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(master_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(master_kasir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_kasir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField agama_kasir;
    private javax.swing.JTextArea alamat_kasir;
    private javax.swing.JButton bbatal;
    private javax.swing.JButton bcari;
    private javax.swing.JButton bhapus;
    private javax.swing.JButton bkeluar;
    private javax.swing.JButton bsimpan;
    private javax.swing.JButton bubah;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cari_text;
    private javax.swing.JTextField id_kasir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.ButtonGroup jk_kasir;
    private javax.swing.JTextField nama_kasir;
    private javax.swing.JTextField password_kasir;
    private javax.swing.JRadioButton rlaki;
    private javax.swing.JRadioButton rperempuan;
    private javax.swing.JTable table_kasir;
    private javax.swing.JTextField telp_kasir;
    // End of variables declaration//GEN-END:variables
}
