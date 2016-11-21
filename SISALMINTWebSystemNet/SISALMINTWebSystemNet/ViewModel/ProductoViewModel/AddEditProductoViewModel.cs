using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using SISALMINTWebSystemNet.Models;
using System.Web.Mvc;

namespace SISALMINTWebSystemNet.ViewModel.ProductoViewModel
{
    public class AddEditProductoViewModel
    {
        public Producto objProducto { get; set; }
        public string codigoProducto { get; set; }

        public bool tieneValor { get; set; }

        public List<Tipo> LstTipo { get; set; }
        public int? TipoID { get; set; }
        public IEnumerable<SelectListItem> selectTipos { get; set; }

        public AddEditProductoViewModel() { }

        public void Fill(string _codigoProducto)
        {
            codigoProducto = _codigoProducto;
            tieneValor = false;
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            if (!string.IsNullOrEmpty(codigoProducto))
            {
                objProducto = context.Producto.FirstOrDefault(x => x.Codigo == codigoProducto);
                TipoID = objProducto.Tipo.TipoId;
                tieneValor = true;
            }
            else objProducto = new Producto();

            LstTipo = context.Tipo.Where(x => x.Estado == "ACT").ToList();
            SelectTipo();
        }

        public void SelectTipo()
        {
            selectTipos = from t in LstTipo select new SelectListItem { Text = t.Nombre + "[ " + t.TipoId + " ]", Value = t.TipoId.ToString() };
        }

        public bool ProductoExiste(string _codigoProducto)
        {
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            Producto objProducto = context.Producto.FirstOrDefault(x => x.Codigo == _codigoProducto);

            if (objProducto != null) return true;
            return false;
        }

        public void RegistrarProducto(Producto _objProducto)
        {
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            _objProducto.Estado = "ACT";
            context.Producto.Add(_objProducto);
            context.SaveChanges();
        }

        public void ModificarProducto(Producto _objProducto)
        {
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            Producto objProducto = context.Producto.FirstOrDefault(x => x.Codigo == _objProducto.Codigo);
            objProducto.Nombre = _objProducto.Nombre;
            objProducto.Marca = _objProducto.Marca;
            objProducto.Modelo = _objProducto.Modelo;
            objProducto.TipoId = _objProducto.TipoId;
            objProducto.FechaIngreso = _objProducto.FechaIngreso;
            objProducto.Distribuidor = _objProducto.Distribuidor;
            objProducto.PrecioCompra = _objProducto.PrecioCompra;
            objProducto.CantidadIngresada = _objProducto.CantidadIngresada;
            objProducto.FallaFabrica = _objProducto.FallaFabrica;
            objProducto.Estado = "ACT";
            context.SaveChanges();
        }

        public void EliminarProducto(string codigoProducto)
        {
            DBSISALMINTEntities context = new DBSISALMINTEntities();
            Producto objProducto = context.Producto.FirstOrDefault(x => x.Codigo == codigoProducto);
            objProducto.Estado = "INA";
            context.SaveChanges();
        }
    }
}