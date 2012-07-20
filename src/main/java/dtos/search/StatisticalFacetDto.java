package dtos.search;

public class StatisticalFacetDto extends AbstractFacet {

	public Long count;
	public Double total;
	public Double sumOfSquares, mean;
	public Double min, max;
	public Double variance, stdDeviation;
	
	public StatisticalFacetDto() {}
	
	public StatisticalFacetDto(String name) {
		super(name);
	}

}
