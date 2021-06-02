package unoesc.edu.Biblioteca.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;


import unoesc.edu.Biblioteca.model.Usuario;



@FacesConverter(value = "usuarioConverter", forClass = Usuario.class)
public class UsuarioConverter implements javax.faces.convert.Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.isEmpty()) {
			Usuario p = (Usuario) component.getAttributes().get(value);
            return p;
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null && (value instanceof Usuario)) {
			Usuario p = (Usuario) value; 
			component.getAttributes().put( String.valueOf(p.getCodigoUser()), p);
            return String.valueOf(p.getCodigoUser());
        }

		return null;
	}

}
