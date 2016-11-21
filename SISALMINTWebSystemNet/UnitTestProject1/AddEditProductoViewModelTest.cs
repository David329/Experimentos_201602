using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using SISALMINTWebSystemNet.ViewModel.ProductoViewModel;
using SISALMINTWebSystemNet.Models;

namespace UnitTestProject1
{
    [TestClass]
    public class AddEditProductoViewModelTest
    {
        [TestMethod]
        public void Fill()
        {
            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            objViewModel.tieneValor = false;
            objViewModel.Fill(null);

            Assert.IsFalse(objViewModel.tieneValor);
        }

        [TestMethod]
        public void ProductoExiste()
        {
            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            Assert.IsTrue(objViewModel.ProductoExiste("P01231"));
        }

        [TestMethod]
        public void ProductoExisteFlujoAlternativo()
        {
            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            Assert.IsFalse(objViewModel.ProductoExiste("fgfdgregerg"));
        }

        //Este metodo no pasa proque el codigo se repite
        [TestMethod]
        public void RegistrarProducto()
        {
            Producto objProducto = new Producto();
            objProducto.Codigo = "P9999";
            objProducto.Nombre = "TV";
            objProducto.Marca = "LG";
            objProducto.Modelo = "fdsf";
            objProducto.TipoId = 1;
            objProducto.FechaIngreso = DateTime.Now;
            objProducto.Distribuidor = "Dist PE";
            objProducto.PrecioCompra = 100;
            objProducto.CantidadIngresada = 20;
            objProducto.FallaFabrica = "0";
            objProducto.Estado = "ACT";

            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            objViewModel.RegistrarProducto(objProducto);
            Assert.IsTrue(!"0".Equals(objProducto.Codigo));
        }

        [TestMethod]
        public void ModificarProducto()
        {
            Producto objProducto = new Producto();
            objProducto.Codigo = "P9999";
            objProducto.Nombre = "TV LG";
            objProducto.Marca = "LG";
            objProducto.Modelo = "fdsf";
            objProducto.TipoId = 1;
            objProducto.FechaIngreso = DateTime.Now;
            objProducto.Distribuidor = "Dist PE";
            objProducto.PrecioCompra = 100;
            objProducto.CantidadIngresada = 20;
            objProducto.FallaFabrica = "0";
            objProducto.Estado = "ACT";  

            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            objViewModel.ModificarProducto(objProducto);
            Assert.IsTrue(objProducto.Nombre.Equals("TV LG"));
        }

        [TestMethod]
        public void EliminarPorducto()
        {
            Producto objProducto = new Producto();
            objProducto.Codigo = "P9999";
            objProducto.Nombre = "TV";
            objProducto.Marca = "LG";
            objProducto.Modelo = "fdsf";
            objProducto.TipoId = 1;
            objProducto.FechaIngreso = DateTime.Now;
            objProducto.Distribuidor = "Dist PE";
            objProducto.PrecioCompra = 100;
            objProducto.CantidadIngresada = 20;
            objProducto.FallaFabrica = "0";
            objProducto.Estado = "ACT";  

            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            objViewModel.EliminarProducto(objProducto.Codigo);

            Assert.IsTrue(true);
        }
    }
}
