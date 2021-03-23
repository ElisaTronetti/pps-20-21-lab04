package u04lab.code

trait Complex {
  def re: Double
  def im: Double
  def +(c: Complex): Complex // should implement the sum of two complex numbers..
  def *(c: Complex): Complex // should implement the product of two complex numbers
}

//this is here just to verify toString and Equals, totally not necessary for implementation purposes
class ComplexImpl(override val re: Double,
                  override val im: Double) extends Complex {
  override def +(c: Complex): Complex = new ComplexImpl(re + c.re, im + c.im)

  override def *(c: Complex): Complex = new ComplexImpl((re * c.re) - (im * c.im), (re * c.im) + (im * c.re))
}

object Complex {
  def apply(re:Double, im:Double):Complex = ComplexImpl(re,im)

  private case class ComplexImpl(override val re: Double,
                         override val im: Double) extends Complex {
    override def +(c: Complex): Complex = Complex(re + c.re, im + c.im)

    override def *(c: Complex): Complex = Complex((re * c.re) - (im * c.im), (re * c.im) + (im * c.re))
  }
}