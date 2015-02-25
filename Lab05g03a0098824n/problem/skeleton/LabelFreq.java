public class LabelFreq {
  // an object describing the vertex label and its frequency
  public String label;
  public int freq;
  public LabelFreq() {}
  public LabelFreq(String l, int f) {
    label = l;
    freq = f;
  }
  public String toString() {
    return new String("("+label+","+freq+")");
  }
}