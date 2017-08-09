package graphic.window2;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PlanePanel extends JPanel implements MouseListener {

	//Desejo saber as seguintes informações para esse PlanePanel:
	//A Matricula da Aeronave(A) do Stage X
	//O Destino da Aeronave(A) do Stage X
	//A Origem da Aeronave(A) do Stage X
	//A Matricula do Piloto da Aeronave(A) do Stage X
	
	private static final long serialVersionUID = 1L;
	private JPanel JPanelAtual;
	private String name;
	private static InterfaceState mainInterface;
	private int number;
	private Color c;
	private List<PlanePanel> suaLista;
	private JLabel jLabel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JTextArea jTextArea1;
    private JTextArea jTextArea2;
    private JTextArea jTextArea3;
    private JTextArea jTextArea4;
    // End of variables declaration    
    
    // Variables declaration - do not modify                     

    public void setColor(Color cor){
    	this.c = cor;
    }
    
    public void setName(String name) {
		this.name = name;
		jLabel1.setText(name);
	}

	public static void setMainInterface(InterfaceState mainInterface) {
		PlanePanel.mainInterface = mainInterface;
	}

	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setC(Color c) {
		this.c = c;
		setColors();
	}

	private void setColors(){
		jTextArea1.setBackground(c);
		jTextArea2.setBackground(c);
		jTextArea3.setBackground(c);
		jTextArea4.setBackground(c);
	}
	
	public void setSuaLista(List<PlanePanel> suaLista) {
		this.suaLista = suaLista;
	}


    
    public PlanePanel(JPanel panel,int n,Color cor, List<PlanePanel> l) {
        JPanelAtual = panel;
        number = n;
        c = cor;
        suaLista = l;
        initComponents();
        this.addMouseListener(this);
    }

    public void setJFrame(InterfaceState jframe){
    	mainInterface = jframe;
    }
    
    public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}
	
	public void setPanelText(String n,String s1,String s2,String s3,String s4){
    	this.name = n;
    	jLabel1.setText(n);
    	jTextArea1.setText(s1);
    	jTextArea2.setText(s2);
    	jTextArea3.setText(s3);
    	jTextArea4.setText(s4);
    }
    
    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static InterfaceState getMainInterface() {
		return mainInterface;
	}

	public Color getC() {
		return c;
	}

	public List<PlanePanel> getSuaLista() {
		return suaLista;
	}

	public JScrollPane getjScrollPane3() {
		return jScrollPane3;
	}

	public JScrollPane getjScrollPane4() {
		return jScrollPane4;
	}

	public JScrollPane getjScrollPane1() {
		return jScrollPane1;
	}

	public JScrollPane getjScrollPane2() {
		return jScrollPane2;
	}

	public JTextArea getjTextArea1() {
		return jTextArea1;
	}

	public JTextArea getjTextArea2() {
		return jTextArea2;
	}

	public JTextArea getjTextArea3() {
		return jTextArea3;
	}

	public JTextArea getjTextArea4() {
		return jTextArea4;
	}

	private void initComponents() {

		
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        
        jLabel1.setText(this.getName());
        
        jTextArea1.addMouseListener(this);
        jTextArea2.addMouseListener(this);
        jTextArea3.addMouseListener(this);
        jTextArea4.addMouseListener(this);


        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        setForeground(new java.awt.Color(255, 255, 255));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane1.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(c);
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jTextArea1.setHighlighter(null);
        jScrollPane1.setViewportView(jTextArea1);

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane2.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(c);
        jTextArea2.setColumns(20);
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jTextArea2.setBorder(null);
        jTextArea2.setHighlighter(null);
        jScrollPane2.setViewportView(jTextArea2);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane3.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea3.setEditable(false);
        jTextArea3.setBackground(c);
        jTextArea3.setColumns(20);
        jTextArea3.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea3.setRows(5);
        jTextArea3.setBorder(null);
        jTextArea3.setHighlighter(null);
        jScrollPane3.setViewportView(jTextArea3);

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jScrollPane4.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane4.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        jTextArea4.setEditable(false);
        jTextArea4.setBackground(c);
        jTextArea4.setColumns(20);
        jTextArea4.setRows(5);
        jTextArea4.setBorder(null);
        jTextArea4.setHighlighter(null);
        jScrollPane4.setViewportView(jTextArea4);

        jLabel1.setBackground(Color.BLACK);
        jLabel1.setForeground(Color.red);
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1,40,40,40)
                .addGap(6, 6, 6))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>                            }                       

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Mouse clicado");
		mainInterface.changePlanePanel(this,this.JPanelAtual,this.suaLista);
	}

	public JPanel getJPanelAtual() {
		return JPanelAtual;
	}

	public void setJPanelAtual(JPanel jPanelAtual) {
		JPanelAtual = jPanelAtual;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
