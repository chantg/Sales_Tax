import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class ExemptItems {
	/*
	Exempt stores tax exempt items alphabetically. The outer ArrayList 0 - 25 represents letters a - z,
	the inner ArrayList are items sorted by their first letter.
	*/
	ArrayList<ArrayList<String>> exempt;
	
	ExemptItems() throws Exception{
		this.exempt = new ArrayList<ArrayList<String>>();
		
		ArrayList<String> a = new ArrayList<String>();ArrayList<String> b = new ArrayList<String>();ArrayList<String> c = new ArrayList<String>();ArrayList<String> d = new ArrayList<String>();ArrayList<String> e = new ArrayList<String>();ArrayList<String> f = new ArrayList<String>();ArrayList<String> g = new ArrayList<String>();ArrayList<String> h = new ArrayList<String>();ArrayList<String> i = new ArrayList<String>();ArrayList<String> j = new ArrayList<String>();ArrayList<String> k = new ArrayList<String>();ArrayList<String> l = new ArrayList<String>();ArrayList<String> m = new ArrayList<String>();ArrayList<String> n = new ArrayList<String>();ArrayList<String> o = new ArrayList<String>();ArrayList<String> p = new ArrayList<String>();ArrayList<String> q = new ArrayList<String>();ArrayList<String> r = new ArrayList<String>();ArrayList<String> s = new ArrayList<String>();ArrayList<String> t = new ArrayList<String>();ArrayList<String> u = new ArrayList<String>();ArrayList<String> v = new ArrayList<String>();ArrayList<String> w = new ArrayList<String>();ArrayList<String> x = new ArrayList<String>();ArrayList<String> y = new ArrayList<String>();ArrayList<String> z = new ArrayList<String>();
		
		//file is the file path to the text file of Tax Exempt items
		File file = new File(System.getProperty("user.dir") + "\\TaxExempt.txt");
		
		BufferedReader bre = new BufferedReader(new FileReader(file)); 
		String str; 

		while ((str = bre.readLine()) != null) {
			switch(Character.toLowerCase(str.charAt(0))) {
			case 'a':
				a.add(str);
				break;
			case 'b':
				b.add(str);
				break;
			case 'c':
				c.add(str);
				break;
			case 'd':
				d.add(str);
				break;
			case 'e':
				e.add(str);
				break;
			case 'f':
				f.add(str);
				break;
			case 'g':
				g.add(str);
				break;
			case 'h':
				h.add(str);
				break;
			case 'i':
				i.add(str);
				break;
			case 'j':
				j.add(str);
				break;
			case 'k':
				k.add(str);
				break;
			case 'l':
				l.add(str);
				break;
			case 'm':
				m.add(str);
				break;
			case 'n':
				n.add(str);
				break;
			case 'o':
				o.add(str);
				break;
			case 'p':
				p.add(str);
				break;
			case 'q':
				q.add(str);
				break;
			case 'r':
				r.add(str);
				break;
			case 's':
				s.add(str);
				break;
			case 't':
				t.add(str);
				break;
			case 'u':
				u.add(str);
				break;
			case 'v':
				v.add(str);
				break;
			case 'w':
				w.add(str);
				break;
			case 'x':
				x.add(str);
				break;
			case 'y':
				y.add(str);
				break;
			case 'z':
				z.add(str);
				break;

			}
				
		}
		
		exempt.add(a);exempt.add(b);exempt.add(c);exempt.add(d);exempt.add(e);exempt.add(f);exempt.add(g);
		exempt.add(h);exempt.add(i);exempt.add(j);exempt.add(k);exempt.add(l); exempt.add(m);exempt.add(n);
		exempt.add(o);exempt.add(p);exempt.add(q);exempt.add(r);exempt.add(s);exempt.add(t);exempt.add(u);
		exempt.add(v);exempt.add(w);exempt.add(x);exempt.add(y);exempt.add(z);
		
		bre.close();
		
	}
}
