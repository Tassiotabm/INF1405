package graphic.window2;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TopLabel extends JPanel {

		private JLabel jLabel1;
		private String txt = "JLabel";
	
	    public TopLabel(String texto) {
	        this.txt = texto;
	        this.setPreferredSize(new Dimension(35,15));
	    	this.setSize(35,15);
	        initComponents();
	    }
	    public void setJLabel(String texto){
	    	this.txt = texto;
	    }
                       
	    private void initComponents() {

	        jLabel1 = new javax.swing.JLabel();

	        jLabel1.setText(txt);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
	        this.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
	        );
	    }// </editor-fold>                        
                
}
