package DSA.codechef_june;

import java.io.*;
import java.util.*;
import java.lang.*;

public class Solution {

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0,
                                 BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }

    static void printCombination(long arr[], long n, long r,Long bits)
    {
        long data[] = new long[(int)r];
        combinationUtil(arr, n, r, 0, data, 0,bits);
        for (int i = 0; i < al.size(); i++) 
        {
            System.out.print(al.get(i) + " ");
        }
        System.out.println();
        al.clear();
    }

    static long xorOfArray(long arr[], Long n)
    {
        long xor_arr = 0;
        for (int i = 0; i < n; i++) {
            xor_arr = xor_arr ^ arr[i];
        }
        return xor_arr;
    }

    static ArrayList<Long> al = new ArrayList<Long>();
    static long max = 0;

    static void combinationUtil(long arr[], long n, long r,long index, long data[], long i,Long bits)
    {
        // int max = (int)(Math.pow(2, bits)) - 1;
        long store=0;
        if (index == r) {
            store = xorOfArray(data, (long)data.length);
            if(store > max)
            {
                max = store;
                for (int j = 0; j < r; j++)
                {
                    al.set(j,data[j]);
                }
                return;
            }
            return;
        }
 
        if (i >= n)
            return;
 
        data[(int)index] = arr[(int)i];
        combinationUtil(arr, n, r, index + 1,data, i + 1,bits);
        combinationUtil(arr, n, r, index, data, i + 1,bits);

    }

    static long countBits(long number)
    {  
        return (int)(Math.log(number) /Math.log(2) + 1);
    }

    public static void main(String[] args) throws IOException {
        
        Reader sc = new Reader();

        long t = sc.nextLong();
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long k = sc.nextLong();

            long a[] = new long[(int)n];

            for(int i=0;i<n;i++)
            {
                a[i]=i+1;
            }

            for(int i=0;i<k;i++)
            {
                al.add((long)100);
            }

            long bits = countBits(n);
            if(k==1)
            {
                System.out.println(n);
                al.clear();
            }
            else if(k==n)
            {
                for(int i=0;i<n;i++)
                {
                    System.out.print(a[i]+" ");
                }
                System.out.println();
                al.clear();
            }
            else{
                printCombination(a, a.length, k,bits);
            }
            max=0;
        }
    }
}