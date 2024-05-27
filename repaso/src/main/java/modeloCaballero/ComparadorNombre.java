package modeloCaballero;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Caballero>{

	@Override
	public int compare(Caballero o1, Caballero o2) {
		return o1.getNombre().compareToIgnoreCase(o2.getNombre());
	}

}
