using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SISALMINTWebSystemNet.Models;

namespace SISALMINTWebSystemNet.ViewModel.ProductoViewModel
{
    public class DetalleProductoViewModel
    {
        public Producto objProducto { get; set; }

        public DetalleProductoViewModel() { }

        public void Fill(string _codigoProdcuto)
        {
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            objProducto = context.Producto.FirstOrDefault(x => x.Codigo == _codigoProdcuto);
        }
    }
}