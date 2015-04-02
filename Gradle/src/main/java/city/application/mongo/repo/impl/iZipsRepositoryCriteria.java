package city.application.mongo.repo.impl;

import java.net.UnknownHostException;
import java.util.List;

import city.application.beans.Zips;

public interface iZipsRepositoryCriteria {

	public abstract List<Zips> findByState(String state);

	public abstract Zips test() throws UnknownHostException;

//	public abstract List<String> findDistinctAllState();

	public abstract List<Zips> findAll();

	public abstract List<Zips> findFirst100ByStateOrderByCityAsc(String state);

}