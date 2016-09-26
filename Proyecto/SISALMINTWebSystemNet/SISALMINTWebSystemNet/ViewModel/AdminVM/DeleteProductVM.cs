using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SISALMINTWebSystemNet.Model;
namespace SISALMINTWebSystemNet.ViewModel.AdminVM
{
    public class DeleteProductVM
    {
        private DBSISALMINTEntities context;
        public void DeleteProduct(string ProductID)
        {
            Products prod = context.Products.FirstOrDefault(x => x.ProductID == ProductID);
            context.Products.Remove(prod);
            context.SaveChanges();
        }
    }
}