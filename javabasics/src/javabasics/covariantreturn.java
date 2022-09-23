package javabasics;
class a{
	int ret(int n,int m) {
		int s=n+m;
		return s;
	}
}
class b extends a{
	float ret(int n,int m,int t) {
		float f=n+m+t;
		return f;
	}
}

public class covariantreturn {
	public static void main(String args[]) {
		b v=new b();
		System.out.println(v.ret(2, 3));
		b v1=new b();
		System.out.println(v1.ret(2, 3, 4));
		
		
	}

}
