package ui.tools;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;


import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

@SuppressWarnings("serial")
public class MyTable extends JTable{
	     //   int myRow=-1,myCol=-1;//
       // TableCellEditor myEditor;//
	
	 DefaultTableCellRenderer render = new DefaultTableCellRenderer();
     DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
	// DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
    public MyTable(Object[][] rowData, Object[] columnNames){
    	super(rowData,columnNames);

	    this.setDragEnabled(false); //关闭自动拖动处理
	    this.setShowGrid(true);//设置表是否绘制单元格周围的网格线
	    this.setPreferredScrollableViewportSize(new Dimension(872, 470));
	    this.setGridColor(Color.BLUE);
	    this.setRowHeight(30);
	    this.setSelectionBackground(Color.blue); 
	    this.setSelectionForeground(Color.white);
	    int column = getColumnCount();
	    for(int i=0;i<column;i++){
	    	this.setTableHeaderColor(this,i,Color.yellow);
	    }
	    
	    DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        this.getTableHeader().setDefaultRenderer(render);
        this.getTableHeader().setPreferredSize(new Dimension(100000, 30));//设置表头高度
        this.getTableHeader().setReorderingAllowed(false);//表头不允许被移动
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中  
        // tcr.setHorizontalAlignment(JLabel.CENTER);  
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样  
        this.setDefaultRenderer(Object.class, tcr);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//设置滚动条
        this.getTableHeader().setFont(new Font("黑体", Font.BOLD, 16));
        this.setFont(new Font("黑体", 0, 16));
        
        for(int i= 0; i<this.getColumnCount(); i++){
            int with = this.getPreferredWidthForCloumn(this,i) + 10;
            with = 200 > with ? 200 : with;
            this.getColumnModel().getColumn(i).setPreferredWidth(with);
          }
    }
    public MyTable(){
    	super();

	    this.setDragEnabled(false); //关闭自动拖动处理
	    this.setShowGrid(true);//设置表是否绘制单元格周围的网格线
	    this.setPreferredScrollableViewportSize(new Dimension(872, 470));
	    this.setGridColor(Color.BLUE);
	    this.setRowHeight(30);
	    this.setSelectionBackground(Color.blue); 
	    this.setSelectionForeground(Color.white);
	    int column = getColumnCount();
	    for(int i=0;i<column;i++){
	    	this.setTableHeaderColor(this,i,Color.yellow);
	    }
	    
	    DefaultTableCellRenderer render = new DefaultTableCellRenderer();
        this.getTableHeader().setDefaultRenderer(render);
        this.getTableHeader().setPreferredSize(new Dimension(100000, 30));//设置表头高度
        this.getTableHeader().setReorderingAllowed(false);//表头不允许被移动
        
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中  
        // tcr.setHorizontalAlignment(JLabel.CENTER);  
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样  
        this.setDefaultRenderer(Object.class, tcr);
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//设置滚动条
        this.getTableHeader().setFont(new Font("黑体", Font.BOLD, 16));
        this.setFont(new Font("黑体", 0, 16));
        
        for(int i= 0; i<this.getColumnCount(); i++){
            int with = this.getPreferredWidthForCloumn(this,i) + 10;
            with = 110 > with ? 110 : with;
            this.getColumnModel().getColumn(i).setPreferredWidth(with);
          }
    }
    public MyTable(DefaultTableModel model){
    	super(model);
    	
        this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//设置滚动条  
	    this.setDragEnabled(false); //关闭自动拖动处理
	    this.setShowGrid(true);//设置表是否绘制单元格周围的网格线
	    this.setPreferredScrollableViewportSize(new Dimension(872, 470));
	    this.setGridColor(Color.BLUE);
	    this.setRowHeight(30);
	    this.setSelectionBackground(Color.blue); 
	    this.setSelectionForeground(Color.white);
	 //   this.setHeaderColor();
	    render.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
	    render.setBackground(Color.yellow );
        this.getTableHeader().setDefaultRenderer(render);
        this.getTableHeader().setPreferredSize(new Dimension(100000, 30));//设置表头高度
        this.getTableHeader().setReorderingAllowed(false);//表头不允许被移动
        this.getTableHeader().setFont(new Font("黑体", Font.BOLD, 16));
        // 设置table内容居中  
        // tcr.setHorizontalAlignment(JLabel.CENTER);  
        tcr.setHorizontalAlignment(SwingConstants.CENTER);// 这句和上句作用一样  
        this.setDefaultRenderer(Object.class, tcr);  
        this.setFont(new Font("黑体", 0, 16));
         
        this.setWidth();

    }
  /*  public void setComboCell(int r,int c,TableCellEditor ce){
        this.myRow=r;
        this.myCol=c;
        this.myEditor=ce;
    }*/
    
	public boolean isCellEditable(int row, int column) { 
		    return false;
		   }
	   
	public void setTableHeaderColor(JTable table, int columnIndex, final Color c){
	        TableColumn column = table.getTableHeader().getColumnModel().getColumn(columnIndex);
	        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
	        cellRenderer.setBackground(c);
	      //  cellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);//表头文字居中       
	        column.setHeaderRenderer(cellRenderer);
   }

	// 取得列幅的最大值
	  public int getPreferredWidthForCloumn(JTable table,int icol){

	    TableColumnModel tcl = table.getColumnModel();
	    TableColumn col = tcl.getColumn(icol);
	    int c = col.getModelIndex(),width = 0,maxw = 0;

	    for(int r=0;r<table.getRowCount();++r){

	      TableCellRenderer renderer = table.getCellRenderer(r,c);
	      Component comp = renderer.getTableCellRendererComponent(table,table.getValueAt(r,c),false,false,r,c);
	      width = comp.getPreferredSize().width;
	      maxw = width > maxw?width:maxw;
	    }
	    return maxw;
	  }
	  
	  public void setHeaderColor (){
		  int column = getColumnCount();
		    for(int i=0;i<column;i++){
		    	this.setTableHeaderColor(this,i,Color.yellow);
		    }
		    
	  }
	  
	  public void setWidth(){
	        for(int i= 0; i<this.getColumnCount(); i++){
	            int with = this.getPreferredWidthForCloumn(this,i) + 10;
	            with = 120 > with ? 120 : with;
	            this.getColumnModel().getColumn(i).setPreferredWidth(with);
	          }
	  }
	  //
	/*    @Override
	    public TableCellEditor getCellEditor(int row, int column) {
	        if(row==myRow&&column==myCol&&myEditor!=null)
	            return myEditor;
	        return super.getCellEditor(row, column);
	    }*/
	    
}