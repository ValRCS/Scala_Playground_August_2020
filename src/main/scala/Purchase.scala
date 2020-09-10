final case class Purchase(region: String,
                    re_num:Long,
                    re_type:String,
                    price: Double,
                    tax_price: Int,
                    area: Double,
                    dom_sk: Int,
                    dom_sauc: Long)
//we use final so nobody tries to extend this case class