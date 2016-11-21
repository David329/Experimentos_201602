using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using SISALMINTWebSystemNet.Models;
using SISALMINTWebSystemNet.ViewModel.HomeViewModel;

namespace SISALMINTWebSystemNet.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult Logout()
        {
            Session.Clear();
            return RedirectToAction("Index", "Home");
        }

        [HttpPost]
        public ActionResult Login(LoginViewModel objViewModel)
        {
            try
            {
                bool autenticado = objViewModel.ValidarLogin();

                if (autenticado)
                {
                    Session["objAdministrador"] = objViewModel.GetAdmin();
                    return RedirectToAction("LstProducto", "Producto");
                }
                else
                {
                    TempData["objMensaje"] = new KeyValuePair<String, String>("ERR", "Credenciales incorrectas.");
                    return RedirectToAction("Index", objViewModel);
                }

            }
            catch (Exception)
            {
                return RedirectToAction("Index", objViewModel);
            }
        }

    }
}