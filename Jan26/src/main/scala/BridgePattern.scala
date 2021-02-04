object BridgePattern extends App {
  trait DataConnectionAPI {
    def behavior: Boolean
  }
  
  trait RelationalDatabases extends DataConnectionAPI {
    override def behavior: Boolean = true  
  }
  
  trait CsvFiles extends DataConnectionAPI {
    override def behavior: Boolean = false 
  }
  
  abstract class DataProcessor {
    this: DataConnectionAPI =>
    def DoIt: Boolean 
  }
  
  class Processor4Oracle extends DataProcessor with RelationalDatabases {
    override def DoIt: Boolean = behavior 
  }
  
}
