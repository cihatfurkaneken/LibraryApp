package tr.edu.javaodev.fe;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import tr.edu.javaodev.dal.YetkilerDAL;
import tr.edu.javaodev.interfaces.IFeInterfaces;
import tr.edu.javaodev.types.Yetkiler;

public class YetkiEkleFE extends JDialog implements IFeInterfaces{

	public YetkiEkleFE() {
		initPencere();
	}

	@Override
	public void initPencere() {
		JPanel panel = initPanel();

		panel.setBorder(BorderFactory.createTitledBorder("Yetki Kayýt Alaný"));
		add(panel);
		setTitle("Yetki Ekle");
		pack();
		setModalityType(DEFAULT_MODALITY_TYPE);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
	}

	@Override
	public JPanel initPanel() {
		JPanel panel = new JPanel(new GridLayout(2,2));
		JLabel adiLabel = new JLabel("Yetki Adý: ",JLabel.RIGHT);
		panel.add(adiLabel);
		JTextField adiField = new JTextField(10);
		panel.add(adiField);
		
		JButton kaydetButton = new JButton("Kaydet");
		panel.add(kaydetButton);
		JButton iptalButton = new JButton("Ýptal");
		panel.add(iptalButton);
		kaydetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Yetkiler contract = new Yetkiler();
				contract.setAdi(adiField.getText());
				new YetkilerDAL().Insert(contract);
				JOptionPane.showMessageDialog(null, contract.getAdi()+" baþarýyla eklendi.");
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
