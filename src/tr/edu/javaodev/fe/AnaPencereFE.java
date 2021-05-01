package tr.edu.javaodev.fe;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import tr.edu.javaodev.complex.types.KitapAlmaContractComplex;
import tr.edu.javaodev.complex.types.KitapStokContractComplex;
import tr.edu.javaodev.complex.types.KitapStokTotalContractComplex;
import tr.edu.javaodev.dal.KitapAlmaDAL;
import tr.edu.javaodev.dal.KitaplarDAL;
import tr.edu.javaodev.dal.StokDAL;
import tr.edu.javaodev.dal.UyeDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.KitapStokContract;
import tr.edu.javaodev.types.KitaplarContract;
import tr.edu.javaodev.types.PersonelContract;
import tr.edu.javaodev.types.UyeContract;
import tr.edu.javaodev.utilities.MenulerCom;

public class AnaPencereFE extends JFrame implements IFeInterfaces {

	public AnaPencereFE() {
		initPencere();
	}

	public void initPencere() {
		JPanel tabs = initPanel();
		add(tabs);
		JMenuBar bar = initBar();
		setJMenuBar(bar);
		pack();
		setTitle("Satýþ ve Stok Programý");
		setSize(850, 550);
		setTitle("Kitap Ekle");
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	public JPanel initPanel() {
		JPanel panel = new JPanel(new BorderLayout());

		JTabbedPane pane = initTabs();
		panel.add(pane, BorderLayout.CENTER);

		return panel;
	}

	public JMenuBar initBar() {
		JMenuBar bar = MenulerCom.initBar();

		return bar;
	}

	public JTabbedPane initTabs() {
		JTabbedPane pane = new JTabbedPane();

		JPanel kitapStokPanel = new JPanel(new BorderLayout());
		JPanel kitapVermePanel = new JPanel(new BorderLayout());

		/* Stok Itemler */

		JPanel kitapStokSolPanel = new JPanel(new BorderLayout());
		JPanel kitapStokSolUstPanel = new JPanel(new GridLayout(5, 2));
		JPanel kitapStokSolAltPanel = new JPanel();

		kitapStokSolPanel.setBorder(BorderFactory.createTitledBorder("Kitap Stok Ekle - Takip Et"));
		Object[] kitapStokKolon = { "Id", "Kitap Adý", "Personel Adý", "Adeti", "Eklenme Tarihi" };
		DefaultTableModel model = new DefaultTableModel(kitapStokKolon, 0);
		JTable table = new JTable(model);
		JScrollPane kitapStokTablePane = new JScrollPane(table);

		for (KitapStokContractComplex contract : new StokDAL().GetAllStok()) {
			model.addRow(contract.getVeriler());
		}

		JLabel stokKitapAdiLabel = new JLabel("Kitap Adý:", JLabel.RIGHT);
		kitapStokSolUstPanel.add(stokKitapAdiLabel);
		JComboBox stokKitapAdiBox = new JComboBox(new KitaplarDAL().GetAll().toArray());
		kitapStokSolUstPanel.add(stokKitapAdiBox);
		JLabel kitapStokAdetLabel = new JLabel("Adet:", JLabel.RIGHT);
		kitapStokSolUstPanel.add(kitapStokAdetLabel);
		JTextField kitapStokAdetField = new JTextField(10);
		KitapStokContract contractYapýcý = new KitapStokContract(1); // yapýcý method kullanýmý ile ilk deðer atamasý
		kitapStokAdetField.setText(String.valueOf(contractYapýcý.getAdet()));
		kitapStokSolUstPanel.add(kitapStokAdetField);

		/* Stokta yoksa koþulu konulcak */
		JLabel kitapStokTarihiLabel = new JLabel("Stoka Giriþ Tarihi:", JLabel.RIGHT);
		kitapStokSolUstPanel.add(kitapStokTarihiLabel);

		JDateChooser kitapStokTarihi = new JDateChooser();
		kitapStokSolUstPanel.add(kitapStokTarihi);

		JButton kitapStokEkleButton = new JButton("Stok Ekle");
		kitapStokSolUstPanel.add(kitapStokEkleButton);
		JButton kitapStokYenileButton = new JButton("Yenile");
		kitapStokSolUstPanel.add(kitapStokYenileButton);

		JButton kitapStokToplamButton = new JButton("Toplam Kitap");
		
		kitapStokToplamButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				int satir = model.getRowCount();
				for(int i = 0;i<satir;i++) {
					model.removeRow(0);
				}
				for (KitapStokTotalContractComplex compContract : new StokDAL().GetTotalStok()) {
					model.addRow(compContract.getVeriler());
					
				}
				
			}
			
			 
		});
		
		
		
		kitapStokSolUstPanel.add(kitapStokToplamButton);
		kitapStokYenileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}

				for (KitapStokContractComplex compContract : new StokDAL().GetAllStok()) {
					model.addRow(compContract.getVeriler());
					
				}
				
				stokKitapAdiBox.removeAllItems();
				JComboBox stokKitapAdiBoxRf = new JComboBox(new KitaplarDAL().GetAll().toArray());
				stokKitapAdiBox.setModel(stokKitapAdiBoxRf.getModel());
				/*for (KitaplarContract compContract : new KitaplarDAL().GetAll()) {
					
					JComboBox stokKitapAdiBox = new JComboBox(new KitaplarDAL().GetAll().toArray());
				}*/
		
				
			}
		});

		kitapStokEkleButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				KitapStokContract contract = new KitapStokContract();
				KitaplarContract uContract = (KitaplarContract) stokKitapAdiBox.getSelectedItem();
				PersonelContract pContract = (PersonelContract) LoginFE.emailBox.getSelectedItem();

				SimpleDateFormat format = new SimpleDateFormat("yyyy/MMMM/dd");
				String date = format.format(kitapStokTarihi.getDate());

				contract.setPersonelId(pContract.getId());
				contract.setKitapId(uContract.getId());
				contract.setTarih(date.toString());
				contract.setAdet(Integer.parseInt(kitapStokAdetField.getText()));

				new StokDAL().Insert(contract);

				JOptionPane.showMessageDialog(null, uContract.getKitapAdi() + " adlý kitap eklenmiþtir.");

				while (model.getRowCount() > 0) {
					model.removeRow(0);
				}

				for (KitapStokContractComplex compContract : new StokDAL().GetAllStok()) {
					if(compContract.getAdet()>0) {
					
					}

					model.addRow(compContract.getVeriler());
				}

			}
		});

		/* Kitap Verme */

		JPanel kitapVermeSagPanel = new JPanel(new BorderLayout());
		JPanel kitapVermeSagUstPanel = new JPanel(new GridLayout(6, 2));
		JPanel kitapVermeSagAltPanel = new JPanel();

		Object[] kitapVermeKolon = { "Id", "Personel Adý", "Öðrenci Numarasý", "Kitap Adý", "Adet", "Verilme Tarihi",
				"Teslim Tarihi" };
		DefaultTableModel vermeModel = new DefaultTableModel(kitapVermeKolon, 0);
		JTable vermeTable = new JTable(vermeModel);
		for (KitapAlmaContractComplex contract : new KitapAlmaDAL().GetAllVerilen()) {
			vermeModel.addRow(contract.getVeriler());
		}

		JScrollPane kitapVermeTablePane = new JScrollPane(vermeTable);

		JLabel ogrLabel = new JLabel("Üye Öðrenci Seç:", JLabel.RIGHT);
		kitapVermeSagUstPanel.add(ogrLabel);
		JComboBox ogrAdiBox = new JComboBox(new UyeDAL().GetAll().toArray());
		kitapVermeSagUstPanel.add(ogrAdiBox);
		ogrAdiBox.setSelectedIndex(0);
		JLabel verilenKitapAdiLabel = new JLabel("Kitap Adý:", JLabel.RIGHT);
		kitapVermeSagUstPanel.add(verilenKitapAdiLabel);
		JComboBox verilenKitapAdiBox = new JComboBox(new KitaplarDAL().GetAll().toArray());
		kitapVermeSagUstPanel.add(verilenKitapAdiBox);
		
		JLabel verilenKitapStokAdetLabel = new JLabel("Adet:", JLabel.RIGHT);
		kitapVermeSagUstPanel.add(verilenKitapStokAdetLabel);
		JTextField verilenKitapStokAdetField = new JTextField(10);
		verilenKitapStokAdetField.setText("1");
		verilenKitapStokAdetField.setEditable(false);
		kitapVermeSagUstPanel.add(verilenKitapStokAdetField);
	
		JLabel verileOgrNoLabel = new JLabel("Öðrenci No:", JLabel.RIGHT);
		kitapVermeSagUstPanel.add(verileOgrNoLabel);
		
		JTextField verileOgrNoField = new JTextField(10);
		verileOgrNoField.setText("Öðrenci Seçiniz");
		kitapVermeSagUstPanel.add(verileOgrNoField);

		verileOgrNoField.setEditable(false);
		ogrAdiBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UyeContract contract = (UyeContract) ogrAdiBox.getSelectedItem();
				verileOgrNoField.setText(contract.getOgrno());
			}
		});

		/* Stokta yoksa koþulu konulcak */
		JLabel verilenKitapStokTarihiLabel = new JLabel("Verilme Tarihi:", JLabel.RIGHT);
		kitapVermeSagUstPanel.add(verilenKitapStokTarihiLabel);

		JDateChooser verilenKitapStokTarihi = new JDateChooser();
		kitapVermeSagUstPanel.add(verilenKitapStokTarihi);
		JTextFieldDateEditor editor = (JTextFieldDateEditor) verilenKitapStokTarihi.getDateEditor();
		editor.setEditable(false);
		verilenKitapStokTarihi.setEnabled(false);
		

		Date bugun = new Date();
		verilenKitapStokTarihi.setDate(bugun);

		JButton verilenKitapEkleButton = new JButton("Kitap Ver");
		kitapVermeSagUstPanel.add(verilenKitapEkleButton);

		verilenKitapEkleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PersonelContract pContract = (PersonelContract) LoginFE.emailBox.getSelectedItem();
				KitaplarContract kContract = (KitaplarContract) verilenKitapAdiBox.getSelectedItem();
				UyeContract uContract = (UyeContract) ogrAdiBox.getSelectedItem();
				KitaplarContract innerContract = new KitaplarContract();
				KitaplarContract.KitapAlmaContract contract = innerContract.new KitapAlmaContract();
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MMMM/dd");
				String date = format.format(verilenKitapStokTarihi.getDate());

				Date today = new Date();
				Calendar cal = new GregorianCalendar();
				cal.setTime(today);
				cal.add(Calendar.DAY_OF_MONTH, +30);
				Date today30 = cal.getTime();

				contract.setKitapId(kContract.getId());
				contract.setPersonelId(pContract.getId());
				contract.setOgrId(uContract.getId());
				contract.setTarih(date);
				contract.setAdet(Integer.parseInt(verilenKitapStokAdetField.getText()));
				contract.setTeslimTarihi((format.format(today30)).toString());
				new KitapAlmaDAL().Insert(contract);

				KitapStokContract stokContract = new KitapStokContract();
				stokContract.setKitapId(kContract.getId());
				stokContract.setPersonelId(pContract.getId());
				stokContract.setTarih(date);
				stokContract.setAdet(-Integer.parseInt(verilenKitapStokAdetField.getText()));

				new StokDAL().Insert(stokContract);

				JOptionPane.showMessageDialog(null, uContract.getAdiSoyadi() + " adlý öðrenciye kitap verilmiþtir.");

			}
		});

		JButton verilenKitapYenileButton = new JButton("Yenile");
		kitapVermeSagUstPanel.add(verilenKitapYenileButton);

		verilenKitapYenileButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				while (vermeModel.getRowCount() > 0) {
					vermeModel.removeRow(0);
				}

				for (KitapAlmaContractComplex contract : new KitapAlmaDAL().GetAllVerilen()) {
					vermeModel.addRow(contract.getVeriler());
				}
				
				
				JComboBox ogrAdiBoxRf = new JComboBox(new UyeDAL().GetAll().toArray());
				ogrAdiBox.setModel(ogrAdiBoxRf.getModel());
			}
		});

		kitapStokPanel.add(kitapStokSolPanel, BorderLayout.WEST);
		kitapStokPanel.add(kitapStokTablePane, BorderLayout.CENTER);

		kitapVermePanel.add(kitapVermeSagPanel, BorderLayout.EAST);
		kitapVermePanel.add(kitapVermeTablePane, BorderLayout.CENTER);

		kitapVermeSagPanel.add(kitapVermeSagUstPanel, BorderLayout.NORTH);
		kitapVermeSagPanel.add(kitapVermeSagAltPanel, BorderLayout.SOUTH);

		kitapStokSolPanel.add(kitapStokSolUstPanel, BorderLayout.NORTH);
		kitapStokSolPanel.add(kitapStokSolAltPanel, BorderLayout.SOUTH);

		pane.addTab("Kitap Stok", null, kitapStokPanel, "Does nothing");
		pane.addTab("Verilen Kitaplar", null, kitapVermePanel, "Does nothing");

		return pane;
	}

}
