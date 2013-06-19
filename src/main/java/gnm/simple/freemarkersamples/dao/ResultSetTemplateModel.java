package gnm.simple.freemarkersamples.dao;

import java.sql.ResultSet;

import freemarker.template.SimpleScalar;
import freemarker.template.TemplateHashModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.TemplateSequenceModel;


//Use with http://jena.apache.org/documentation/javadoc/arq/com/hp/hpl/jena/query/ResultSetFactory.html
// http://jena.apache.org/
public class ResultSetTemplateModel implements TemplateSequenceModel {
	
	private ResultSet rs = null;
	public ResultSetTemplateModel(ResultSet rs) {
		this.rs = rs;
	}	
	public TemplateModel get(int i) throws TemplateModelException {
		try {
			rs.next();
		} catch(Exception e) { 
			throw new TemplateModelException(e.toString());
		}
		TemplateModel model = new Row(rs);
		return model;
	}

	public int size() throws TemplateModelException {
		int size=0;
		try {
			rs.last();
			size = rs.getRow();
			rs.beforeFirst();
		} catch (Exception e ) {
			throw new TemplateModelException( e.toString());
		}
		return size;
	}


	class Row implements TemplateHashModel {

		private ResultSet rs = null;
		public Row(ResultSet rs) {
			this.rs = rs;
		}

		public TemplateModel get(String s) throws TemplateModelException {
			TemplateModel model = null;
			try {
				model = new SimpleScalar( rs.getString(s) );
			} catch (Exception e) { e.printStackTrace(); }
			return model;
		}

		public boolean isEmpty() throws TemplateModelException {
			boolean isEmpty = false;
			if ( rs == null ) { isEmpty = true; }
			return isEmpty;
		}

	}
}
