package is.bokun.dtos;

import java.util.*;

import org.codehaus.jackson.annotate.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HasBookableExtras implements WithExtras {

	public List<BookableExtraDto> extras = new ArrayList<>();

    @JsonIgnore
	public BookableExtraDto findExtra(Long id) {
		for (BookableExtraDto e : extras) {
			if ( e.id.equals(id) ) {
				return e;
			}
		}
		return null;
	}
    
    @JsonIgnore
    public List<BookableExtraDto> getSortedExtras() {
    	Collections.sort(extras, new Comparator<BookableExtraDto>() {
			@Override
			public int compare(BookableExtraDto o1, BookableExtraDto o2) {
				if ( o1.included && !o2.included ) {
					return -1;
				} else if ( !o1.included && o2.included ) {
					return 1;
				} else {
					return o1.title.compareTo(o2.title);
				}
			}
    	});
    	return extras;
    }
    
    @JsonIgnore
    public List<BookableExtraDto> getExtrasByFlag(String flag) {
    	List<BookableExtraDto> list = new ArrayList<>();
    	for (BookableExtraDto e : getSortedExtras()) {
    		if ( e.flags.contains(flag) ) {
    			list.add(e);
    		}
    	}
    	return list;
    }
    
    @JsonIgnore
    public List<BookableExtraDto> getExtrasExcludingFlag(String flag) {
    	List<BookableExtraDto> list = new ArrayList<>();
    	for (BookableExtraDto e : getSortedExtras()) {
    		if ( !e.flags.contains(flag) ) {
    			list.add(e);
    		}
    	}
    	return list;
    }
	
	@JsonIgnore
	public List<BookableExtraDto> getIncludedExtras() {
		List<BookableExtraDto> list = new ArrayList<>();
		for ( BookableExtraDto e : extras ) {
			if ( e.included ) {
				list.add(e);
			}
		}
		return list;
	}
	
	@JsonIgnore
	public List<BookableExtraDto> getOptionalExtras() {
		List<BookableExtraDto> list = new ArrayList<>();
		for ( BookableExtraDto e : extras ) {
			if ( !e.included ) {
				list.add(e);
			}
		}
		return list;
	}
}
