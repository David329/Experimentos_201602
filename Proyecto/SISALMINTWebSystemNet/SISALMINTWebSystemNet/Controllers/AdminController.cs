using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SISALMINTWebSystemNet.ViewModel.AdminVM;
namespace SISALMINTWebSystemNet.Controllers
{
    public class AdminController : Controller
    {
        public ActionResult AdmInicio()
        {
            return View();
        }
        public ActionResult Logout()
        {
            Session.Clear();
            return RedirectToAction("Index", "Home");
        }
        #region Productos
        public ActionResult DeleteProduct(string ProductID)
        {
            try
            {
                DeleteProductVM objViewModel = new DeleteProductVM();
                objViewModel.DeleteProduct(ProductID);
                return RedirectToAction("LstPlaces");
            }
            catch (Exception)
            {
                throw;
            }
        }
        public ActionResult LstProducts()
        {
            try
            {
                LstProductsVM objViewModel = new LstProductsVM();
                objViewModel.lstProducts = objViewModel.GetLstProducts();
                return View("LstProducts", objViewModel);
            }
            catch (Exception)
            {
                throw;
            }
        }
        [HttpPost]
        public ActionResult LstProducts(LstProductsVM objViewModel)
        {
            try
            {
                objViewModel.lstProducts = objViewModel.GetLstProducts();
                return View("LstProducts", objViewModel);
            }
            catch (Exception)
            {
                throw;
            }
        }
        #endregion
    }
}