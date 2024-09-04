package Exe.Ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;

import Exe.Ex4.geo.Circle2D;
import Exe.Ex4.geo.GeoShapeable;
import Exe.Ex4.geo.Point2D;
import Exe.Ex4.geo.Polygon2D;
import Exe.Ex4.geo.Rect2D;
import Exe.Ex4.geo.Segment2D;
import Exe.Ex4.geo.Triangle2D;


public class GUIShape implements GUI_Shapeable{
	private GeoShapeable _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	private boolean _isSelected;
	public int num=0;
	
	public GUIShape(GeoShapeable g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
		_isSelected = false;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	
	@Override
	public GeoShapeable getShape() {
		return _g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shapeable copy() {
		GUIShape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		String a = "GUIShape,"+this.getColor().getRGB()+","+this.isFilled()+","+this.getTag()+",";
		if(this.getShape() instanceof Segment2D) {a+="Segment2D,";}
		if(this.getShape() instanceof Rect2D) {a+="Rect2D,";}
		if(this.getShape() instanceof Circle2D) {a+="Circle2D,";}
		if(this.getShape() instanceof Triangle2D) {a+="Triangle2D,";}
		if(this.getShape() instanceof Polygon2D) {a+="Polygon2D,";}

		for(int i=0;i<this.getShape().getPoints().length;i++)
		{
			a=a+this.getShape().getPoints()[i].x()+",";
			a=a+this.getShape().getPoints()[i].y();
			if(i!=this.getShape().getPoints().length-1)a=a+","; //so that there is no comma at the end
		}
		if(this.getShape() instanceof Rect2D) {
			Rect2D rect = (Rect2D)this.getShape();
			a+=","+rect.PointOf_MaxX_MinY.x()+","+rect.PointOf_MaxX_MinY.y()+","+rect.PointOf_MinX_MaxY.x()+","+rect.PointOf_MinX_MaxY.y();
		}
		return a;
	}
	
	private void init(String [] ww)
	{
		//פונקציית עזר לload
		//מקבל סטרינג שמתאר צורה למוסיף את הצורה לאוסף
	}
	
	@Override
	public boolean isSelected() {
		return this._isSelected;
	}
	@Override
	public void setSelected(boolean s) {
		this._isSelected = s;
	}
	@Override
	public void setShape(GeoShapeable g) {
		_g= g;
	}
}
