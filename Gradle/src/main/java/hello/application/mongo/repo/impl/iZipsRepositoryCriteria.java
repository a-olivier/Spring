package hello.application.mongo.repo.impl;

import hello.application.beans.Zips;

import java.net.UnknownHostException;
import java.util.List;

public interface iZipsRepositoryCriteria {

	public abstract List<Zips> findByState(String state);

	public abstract Zips test() throws UnknownHostException;

//	public abstract List<String> findDistinctAllState();

	public abstract List<Zips> findAll();

	public abstract List<Zips> findFirst100ByStateOrderByCityAsc(String state);

}