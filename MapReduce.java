import java.util.Arrays;


public class MapReduce {
	
	public static String kf[];
	public static int vf[];
	
	public static void main(String[] args) {
		Map();
		Reduce();
	}
	
	public static int Map() {
		int matrix[][] = { {0,2,4,6,8},{1,3,5,7,9},{12,24,46,68,89},{112,124,416,618,189} };
		int nombrecol = matrix[0].length;
		int nombreligne = matrix.length;
		System.out.println("Lecture du tableau d'entrée...");
		System.out.println("Nombre de colonnes du tableau d'entrée : " + nombrecol);
		System.out.println("Nombre de lignes du tableau d'entrée : " + nombreligne);
		System.out.println("Mapping du tableau d'entrée...");
		String k[] = new String[nombrecol*nombreligne];
		int v[] = new int[nombrecol*nombreligne];
		int jt = -1;
		int it = -1;
		for (int j = 0; j <= nombreligne-1; j++) {
			for(int i = 0; i <= (nombrecol-1); i++)
			{ 
				jt = jt+1;
				it = it+1;
				k[jt] = (j + "." + i);
				v[jt] = matrix[j][i];
			}
		}
		kf = k;
		vf = v;
		return(0);
	}
	
	public static int Reduce() {
		System.out.println("Couple de clés : [k:v], [Position de ligne, Position de colonne] :");
		System.out.println(Arrays.toString(kf));
		System.out.println("Valeur associée aux clés :");
		System.out.println(Arrays.toString(vf));
		int numberofkey = vf.length;
		String lastkey = kf[numberofkey-1];
		String[] sizeoftab = lastkey.split("[.]");
		String nbcoltmp = sizeoftab[0];
		String nblinetmp = sizeoftab[1];
		int nbcol = Integer.parseInt(nbcoltmp);
		int nbline = Integer.parseInt(nblinetmp);
		int jt = -1;
		int newvf[] = new int[((nbline+1)*(nbcol+1))];;
		System.out.println("Pivot du tableau : ");
		System.out.println("Nombre de colonnes du nouveau tableau: " + (nbcol+1));
		System.out.println("Nombre de lignes du nouveau tableau : " + (nbline+1));
		for (int j = 0; j <= nbline; j++) {
			for(int i = 0; i <= nbcol; i++)
			{ 
				jt = jt+1;
				newvf[jt] = vf[Arrays.asList(kf).indexOf(i+"."+j)];
			}
		}
		System.out.println("Tableau transposé : ");
		System.out.println(Arrays.toString(newvf));
		System.out.println(Arrays.toString(kf));
		return(0);
	}
}
