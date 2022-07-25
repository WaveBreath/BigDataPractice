object Main {
  def main(args:Array[String]) :Unit= {
    var a=0;
    var b=0;
    for(a<-1 to 9){
        for(b<-1 to a)
            printf("%dx%d=%d\t",a,b,a*b);
        println("");
    }
}
