using System;
using System.Collections.Generic;
using System.Web.Mvc;
using SISALMINTWebSystemNet.ViewModel.ProductoViewModel;

namespace SISALMINTWebSystemNet.Controllers
{
    public class ProductoController : Controller
    {
        public ActionResult LstProducto()
        {
            LstProductoViewModel objViewModel = new LstProductoViewModel();
            objViewModel.Fill();
            return View(objViewModel);
        }

        [HttpPost]
        public ActionResult LstProducto(LstProductoViewModel objViewModel)
        {
            objViewModel.Fill();
            return View("LstProducto", "_Layout", objViewModel);
        }

        public ActionResult DetalleProducto(string codigoProducto)
        {
            DetalleProductoViewModel objViewModel = new DetalleProductoViewModel();
            objViewModel.Fill(codigoProducto);
            return View("DetalleProducto", "_Layout", objViewModel);
        }

        public ActionResult AddEditProducto(string codigoProducto)
        {
            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            objViewModel.Fill(codigoProducto);
            objViewModel.objProducto.FechaIngreso = Convert.ToDateTime("1999-01-01");
            objViewModel.codigoProducto = objViewModel.objProducto.Codigo;
            return View("AddEditProducto", "_Layout", objViewModel);
        }
        [HttpPost]
        public ActionResult AddEditProducto(AddEditProductoViewModel objViewModel)
        {
            try
            {
                objViewModel.objProducto.Codigo = objViewModel.codigoProducto;
                if (objViewModel.tieneValor)
                {

                    objViewModel.ModificarProducto(objViewModel.objProducto);
                }
                else
                {
                    if(!objViewModel.ProductoExiste(objViewModel.objProducto.Codigo))
                        objViewModel.RegistrarProducto(objViewModel.objProducto);
                    else
                    {
                        TempData["objMensaje"] = new KeyValuePair<String, String>("ERR", "El código de producto ya existe.");
                        objViewModel.Fill("");
                        objViewModel.objProducto.FechaIngreso = Convert.ToDateTime("1999-01-01");
                        return View("AddEditProducto", "_Layout", objViewModel);
                    }
                    
                }
                   

                String MensajeRespuesta = objViewModel.tieneValor ? "El producto se actualizó correctamente." : "El producto se registró correctamente.";
                TempData["objMensaje"] = new KeyValuePair<String, String>("SUC", MensajeRespuesta);

                objViewModel.Fill("");
                objViewModel.objProducto.FechaIngreso = Convert.ToDateTime("1999-01-01");
                return View("AddEditProducto", "_Layout", objViewModel);
            }
            catch (Exception ex)
            {
                string a = ex.Message;
                TempData["objMensaje"] = new KeyValuePair<String, String>("ERR", "Por favor intente más tarde.");
                return RedirectToAction("AddEditProducto", objViewModel.codigoProducto);
            }

        }

        public ActionResult EliminarProducto(string codigoProducto)
        {
            try
            {
                AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
                objViewModel.EliminarProducto(codigoProducto);

                TempData["objMensaje"] = new KeyValuePair<String, String>("SUC", "El producto ha sido eliminado.");
                return RedirectToAction("LstProducto");
            }
            catch (Exception)
            {

                TempData["objMensaje"] = new KeyValuePair<String, String>("ERR", "No se ha podido eliminar el producto.");
                return RedirectToAction("LstProducto");
            }

        }
    }
}