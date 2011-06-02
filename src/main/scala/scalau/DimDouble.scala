package scalau

class DimDouble (d: Double) {
  def /[B <: Quantity, Res <: Quantity](other: B)(implicit divide: (Double, B, Null) => Res): Res = {
  	val r = divide(d, other, null)
  	println("" + d + "/" + other.x + "=" + r)
  	r
  }

  def *[B <: Quantity](other: B)(implicit a: Null): B = {
  	other.build(d * other.x).asInstanceOf[B]
  }
  
}

