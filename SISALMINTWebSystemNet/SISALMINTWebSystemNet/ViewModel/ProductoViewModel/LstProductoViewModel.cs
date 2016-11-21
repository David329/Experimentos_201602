using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SISALMINTWebSystemNet.Models;

namespace SISALMINTWebSystemNet.ViewModel.ProductoViewModel
{
    public class LstProductoViewModel
    {
        public string Filtro { get; set; }
        public List<Producto> LstProducto { get; set; }
        public LstProductoViewModel() { }

        public void Fill()
        {
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            var a = context.Producto.ToList().Count;
            var query = context.Producto.Where(x => x.Estado == "ACT").AsQueryable();

            if (!string.IsNullOrEmpty(Filtro))
                query = query.Where(x => x.Nombre.ToUpper().Contains(Filtro.ToUpper()));

            LstProducto = query.ToList();
        }
    }
}