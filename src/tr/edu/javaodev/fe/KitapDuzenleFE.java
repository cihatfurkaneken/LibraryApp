package tr.edu.javaodev.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import tr.edu.javaodev.dal.KategoriDAL;
import tr.edu.javaodev.dal.KitaplarDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.KategoriContract;
import tr.edu.javaodev.types.KitaplarContract;

public class KitapDuzenleFE extends JDialog implements IFeInterfaces{

	public KitapDuzenleFE(){
		initPencere();
	}
	@Override
	public void initPencere() {
		JPanel panel = initPanel();
		add(panel);
		setTitle("Kitap Düzenle");
		pack();
		setVisible(true);
		setLocationRelativeTo(null);
		setModalityType(DEFAULT_MODALITY_TYPE);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(6 ,2));

		JLabel kitapLabel = new JLabel("Kitap Seç:",JLabel.RIGHT);
		panel.add(kitapLabel);
		JComboBox kitaplarBox = new JComboBox(new KitaplarDAL().GetAll().toArray());
		panel.add(kitaplarBox);
		
		JLabel kitapAdiLabel = new JLabel("Kitap Adi:",JLabel.RIGHT);
		panel.add(kitapAdiLabel);
		JTextField kitapAdiField = new JTextField(35);
		panel.add(kitapAdiField);
		
		JLabel kategoriLabel = new JLabel("Kategori:",JLabel.RIGHT);
		panel.add(kategoriLabel);
		JComboBox kategorilerBox = new JComboBox(new KategoriDAL().GetAll().toArray());
		panel.add(kategorilerBox);
		
		JLabel kitapEklenmeTarihiLabel = new JLabel("Tarih:",JLabel.RIGHT);
		panel.add(kitapEklenmeTarihiLabel);
		JDateChooser tarihDate = new JDateChooser();
		panel.add(tarihDate);
		
		JLabel kitapSayfaLabel = new JLabel("Sayfa:",JLabel.RIGHT);
		panel.add(kitapSayfaLabel);
		JTextField kitapSayfaField = new JTextField(15);
		panel.add(kitapSayfaField);
		
		
		kitaplarBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*SimpleDateFormat format = new SimpleDateFormat;
				
		
			    Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);*/
			
				KitaplarContract contract =  (KitaplarContract) kitaplarBox.getSelectedItem();
				//KategoriContract kContract = (KategoriContract) kategorilerBox.getSelectedItem();
				
				
				
				Date tarih = null;
				try {
					tarih = new SimpleDateFormat("yyyy/MMMM/dd").parse(contract.getTarih());
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				kitapAdiField.setText(contract.getKitapAdi());
				kategorilerBox.setSelectedIndex(contract.getKategoriId()-1);
				tarihDate.setDate(tarih);
				kitapSayfaField.setText(String.valueOf(contract.getSayfa()));
				
			}
		});
		
		JButton kitapDuzenleButton = new JButton ("Düzenle");
		panel.add(kitapDuzenleButton);
		
		kitapDuzenleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KitaplarContract contract = new KitaplarContract();
				KitaplarContract castContract =  (KitaplarContract) kitaplarBox.getSelectedItem();
				KategoriContract kContract = (KategoriContract) kategorilerBox.getSelectedItem();
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy/MMMM/dd");
				String date = format.format(tarihDate.getDate());
				
				contract.setId(castContract.getId());
				contract.setKategoriId(kContract.getId());
				contract.setKitapAdi(kitapAdiField.getText());
				contract.setTarih(date);
				contract.setSayfa(Integer.valueOf(kitapSayfaField.getText()));
				
				new KitaplarDAL().Update(contract);
				JOptionPane.showMessageDialog(null, contract.getKitapAdi()+" adlý kitap düzenlenmiþtir.");
				
			}
				
		});
		
		
		
		
		
		JButton kitapDuzenleIptalButton = new JButton ("Ýptal");
		panel.add(kitapDuzenleIptalButton);
		
		return panel;
	}

	@Override
	public JMenuBar initBar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JTabbedPane initTabs() {
		// TODO Auto-generated method stub
		return null;
	}

}
