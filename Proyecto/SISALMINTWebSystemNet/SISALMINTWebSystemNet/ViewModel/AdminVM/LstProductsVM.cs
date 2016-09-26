using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SISALMINTWebSystemNet.Model;
namespace SISALMINTWebSystemNet.ViewModel.AdminVM
{
    public class LstProductsVM
    {
        private DBSISALMINTEntities context;
        public List<Products> lstProducts { get; set; }
        public string Filtro { get; set; }

        public List<Products> GetLstProducts()
        {
            context = new DBSISALMINTEntities();
            if (string.IsNullOrEmpty(Filtro)) return context.Products.ToList();
            else return context.Products.Where(x => x.ProductName == Filtro).ToList();
        }
    }
}