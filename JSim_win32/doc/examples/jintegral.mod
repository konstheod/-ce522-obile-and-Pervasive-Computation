// calculating integral via java function
source real function jintegral(u@t) {
  language="java";
  maincode={{
    RegularGridData t = (RegularGridData) u.grid(0);
    int[] inx = new int[1];
    double tot = 0;
    for (int i=0; i<t.ct(); i++) {
      int mult = 2;
      if (i==0 || i==t.ct()-1) mult = 1;
      inx[0] = i;
      tot += mult*u.realVal(inx);
    }
    tot *= (t.max() - t.min()) / (2*(t.ct() - 1));
    return tot;   
  }};
}

math main {
  realDomain t;
  t.min=0; t.max=5; t.delta=1;
  real u(t) = t*t;
  real v = jintegral(u@t);
} 
