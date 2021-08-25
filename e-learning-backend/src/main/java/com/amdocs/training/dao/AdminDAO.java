package com.amdocs.training.dao;

import com.amdocs.training.model.Admin;

public interface AdminDAO {
	boolean saveAdmin(Admin admin);
	boolean validAdmin(Admin admin);
}
