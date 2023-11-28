using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Algorithm
{
    internal class Program
    {
        static void Main(string[] args)
        {
            int[] arr = new int[] { 1,1,2,2,3,3 };
            int[] result = arr.Distinct().ToArray();
            
            Console.ReadLine();
        }
    }
}
