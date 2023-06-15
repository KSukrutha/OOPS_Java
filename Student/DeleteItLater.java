package sdbms;

public class DeleteItLater {
	static boolean isPrime(int n) {
		int c=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				c++;
			}
		}
			if(c==2) {
				return true;
			}
			else {
				return false;
			}
		}
			public static void main(String[] args) {
				int c=0;
				int n=29;
				for(int i=1;i<=n;i++) {
					if (isPrime(i)==true) {
						System.out.println(n +"  "+ c);
						break;
					}
					c++;
				}
			}
		}


