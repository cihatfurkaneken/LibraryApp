package tr.edu.javaodev.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
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

public class KitapEkleFE extends JDialog implements IFeInterfaces {

	public KitapEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Kitap Kayýt Alaný"));
		add(panel);
		setTitle("Kitap Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(5, 2));

		JLabel adiLabel = new JLabel("Kitap Adý:", JLabel.RIGHT);
		panel.add(adiLabel);

		JTextField adiField = new JTextField(10);
		panel.add(adiField);

		JLabel kategoriLabel = new JLabel("Kategori Seç:", JLabel.RIGHT);
		panel.add(kategoriLabel);

		JComboBox kategoriBox = new JComboBox(new KategoriDAL().GetAll().toArray());
		panel.add(kategoriBox);

		JLabel tarihLabel = new JLabel("Tarih Seç:", JLabel.RIGHT);
		panel.add(tarihLabel);

		JDateChooser tarihDate = new JDateChooser();
		panel.add(tarihDate);

		JLabel sayfaLabel = new JLabel("Sayfa Bilgisi Gir:", JLabel.RIGHT);
		panel.add(sayfaLabel);

		JTextField sayfaField = new JTextField(10);
		panel.add(sayfaField);

		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);

		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);

		kaydetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				KitaplarContract contract = new KitaplarContract();
				KategoriContract casContract = (KategoriContract) kategoriBox.getSelectedItem();

				SimpleDateFormat format = new SimpleDateFormat("yyyy/MMMM/dd");
				
				/*Date today = new Date();
				Calendar cal = new GregorianCalendar();
				cal.setTime(today);
				cal.add(Calendar.DAY_OF_MONTH, +30);
				Date today30 = cal.getTime();*/
				
				String date = format.format(tarihDate.getDate());
				contract.setKitapAdi(adiField.getText());
				contract.setKategoriId(casContract.getId());
				/*contract.setTarih((format.format(today30)).toString());*/
				contract.setTarih(date);
				contract.setSayfa(Integer.parseInt(sayfaField.getText()));
				new KitaplarDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, "Kitap Baþarýyla Eklendi");
				
				
				
			}
		});

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
