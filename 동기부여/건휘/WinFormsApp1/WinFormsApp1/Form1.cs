using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace WinFormsApp1
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();

            Sonata myCar = new Sonata();         
        }
    }

    class Cat
    {
        string Name;
        int Age;
    }

    class Sonata
    {
        string Color;
        bool HasSunRoof;
    }
}
