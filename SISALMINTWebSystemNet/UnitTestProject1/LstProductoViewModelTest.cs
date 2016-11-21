using SISALMINTWebSystemNet.ViewModel.ProductoViewModel;
using NUnit.Framework;
namespace UnitTestProject1
{
    [TestFixture]
    public class LstProductoViewModelTest
    {
        [Test]
        public void Fill()
        {
            LstProductoViewModel objViewModel = new LstProductoViewModel();
            objViewModel.Fill();
            Assert.AreNotEqual(0, objViewModel.LstProducto.Count);
        }

        [Test]
        public void FillBuscar()
        {
            LstProductoViewModel objViewModel = new LstProductoViewModel();
            objViewModel.Filtro = "999";
            objViewModel.Fill();
            Assert.AreEqual(0, objViewModel.LstProducto.Count);
        }

        [Test]
        public void FillBuscarFlujoAlternativo()
        {
            LstProductoViewModel objViewModel = new LstProductoViewModel();
            objViewModel.Filtro = "assa7fs89a7f";
            objViewModel.Fill();
            Assert.AreEqual(0, objViewModel.LstProducto.Count);
        }
    }
}
