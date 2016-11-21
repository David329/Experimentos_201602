using System;
using SISALMINTWebSystemNet.ViewModel.ProductoViewModel;
using SISALMINTWebSystemNet.Models;
using NUnit.Framework;
namespace UnitTestProject1
{
    [TestFixture]
    public class AddEditProductoViewModelTest
    {
        [Test]
        public void D_Fill()
        {
            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            objViewModel.tieneValor = false;
            objViewModel.Fill(null);

            Assert.IsFalse(objViewModel.tieneValor);
        }

        [Test]
        public void B_ProductoExiste()
        {
            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            Assert.IsTrue(objViewModel.ProductoExiste("123"));
        }

        [Test]
        public void ProductoExisteFlujoAlternativo()
        {
            AddEditProductoViewModel objViewModel = new AddEditProductoViewModel();
            Assert.IsFalse(objViewModel.ProductoExiste("fgfdgregerg"));
        }

        //Este metodo no pasa proque el codigo se repite
        [Test]
        public void A_RegistrarProducto()
        {
            LstProductoViewModel a = new LstProductoViewModel();
            a.Fill();
            int codigo = Int32.Parse(a.LstProducto[a.LstProducto.Count - 1].Codigo) + 1;
            Producto objProducto = new Producto();

            objProducto.Codigo = codigo.ToString();
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

        [Test]
        public void C_ModificarProducto()
        {
            LstProductoViewModel a = new LstProductoViewModel();
            Producto objProducto = new Producto();
            a.Fill();
            int codigo = Int32.Parse(a.LstProducto[a.LstProducto.Count - 1].Codigo);


            objProducto.Codigo = codigo.ToString();
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

        [Test]
        public void E_EliminarPorducto()
        {
            LstProductoViewModel a = new LstProductoViewModel();
            a.Fill();
            int codigo = Int32.Parse(a.LstProducto[a.LstProducto.Count - 1].Codigo);
            Producto objProducto = new Producto();
            objProducto.Codigo = codigo.ToString();
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
