package unoesc.edu.Biblioteca.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import unoesc.edu.Biblioteca.model.Livro;



@FacesConverter(value = "livroConverter", forClass = Livro.class)
public class LivroConverter implements javax.faces.convert.Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			System.out.println("Tentou\n\n");
			Livro p = (Livro) component.getAttributes().get(value);
            return p;
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Livro)) {
			Livro p = (Livro) value; 
			component.getAttributes().put( String.valueOf(p.getCodigoLivro()), p);
            return String.valueOf(p.getCodigoLivro());
        }

		return null;
	}

}
