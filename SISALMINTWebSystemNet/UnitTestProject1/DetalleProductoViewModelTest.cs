using SISALMINTWebSystemNet.ViewModel.ProductoViewModel;
using NUnit.Framework;
namespace UnitTestProject1
{
    [TestFixture]
    public class DetalleProductoViewModelTest
    {
        [Test]
        public void Fill()
        {
            DetalleProductoViewModel objViewModel = new DetalleProductoViewModel();
            objViewModel.Fill("P01231");

            Assert.IsNull(objViewModel.objProducto);
        }

        [Test]
        public void FillFlujoAlternativo()
        {
            DetalleProductoViewModel objViewModel = new DetalleProductoViewModel();
            objViewModel.Fill("dfsdf");

            Assert.IsNull(objViewModel.objProducto);
        }
    }
}
